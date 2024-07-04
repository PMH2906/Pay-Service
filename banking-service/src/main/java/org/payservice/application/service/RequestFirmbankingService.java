package org.payservice.application.service;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.payservice.UseCase;
import org.payservice.adapter.out.external.bank.ExternalFirmbankingRequest;
import org.payservice.adapter.out.external.bank.FirmbankingResult;
import org.payservice.adapter.out.persistence.FirmbankingRequestJpaEntity;
import org.payservice.adapter.out.persistence.FirmbankingRequestMapper;
import org.payservice.application.port.in.FirmbankingRequestCommand;
import org.payservice.application.port.in.RequestFirmbankingUseCase;
import org.payservice.application.port.out.FirmbankingRequestPort;
import org.payservice.application.port.out.RequestExternalFirmbankingPort;
import org.payservice.domain.FirmbankingRequest;
import org.payservice.domain.FirmbankingRequest.FirmBankingStatus;
import org.payservice.domain.FirmbankingRequest.FromBankAccountNumber;
import org.payservice.domain.FirmbankingRequest.FromBankName;
import org.payservice.domain.FirmbankingRequest.MoneyAmount;
import org.payservice.domain.FirmbankingRequest.ToBankAccountNumber;
import org.payservice.domain.FirmbankingRequest.ToBankName;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class RequestFirmbankingService implements RequestFirmbankingUseCase {

    private final FirmbankingRequestMapper mapper;
    private final FirmbankingRequestPort firmbankingRequestPort;
    private final RequestExternalFirmbankingPort requestExternalFirmbankingPort;

    @Override
    public FirmbankingRequest requestFirmbanking(FirmbankingRequestCommand command) {


        FirmbankingRequestJpaEntity requestJpaEntity = firmbankingRequestPort.createFirmbankingRequest(
            new FromBankName(command.getFromBankName()),
            new FromBankAccountNumber(command.getFromBankAccountNumber()),
            new ToBankName(command.getToBankName()),
            new ToBankAccountNumber(command.getToBankNameAccountNumber()),
            new MoneyAmount(command.getMoneyAmount()),
            new FirmBankingStatus(0)
        );

        // 외부 은행에 펌뱅킹 요청
        FirmbankingResult result = requestExternalFirmbankingPort.requestExternalFirmbanking(new ExternalFirmbankingRequest(
            command.getFromBankName(),
            command.getFromBankAccountNumber(),
            command.getToBankName(),
            command.getToBankNameAccountNumber()
        ));

        // Transactional UUID
        UUID randomUUID = UUID.randomUUID();
        requestJpaEntity.setUuid(randomUUID);

        if(result.getResultCode()==0) {
            requestJpaEntity.setFirmBankingStatus(1);
        } else {
            requestJpaEntity.setFirmBankingStatus(2);
        }

        return mapper.mapToDomainEntity(firmbankingRequestPort.modifyFirmbankingRequest(requestJpaEntity), randomUUID);
    }
}
