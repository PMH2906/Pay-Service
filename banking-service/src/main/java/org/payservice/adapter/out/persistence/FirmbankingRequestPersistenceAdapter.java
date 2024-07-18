package org.payservice.adapter.out.persistence;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.payservice.ExternalSystemAdapter;
import org.payservice.adapter.out.external.bank.BankAccount;
import org.payservice.adapter.out.external.bank.ExternalFirmbankingRequest;
import org.payservice.adapter.out.external.bank.FirmbankingResult;
import org.payservice.adapter.out.external.bank.GetBankAccountRequest;
import org.payservice.application.port.out.FirmbankingRequestPort;
import org.payservice.application.port.out.RequestBankAccountInfoPort;
import org.payservice.application.port.out.RequestExternalFirmbankingPort;
import org.payservice.domain.FirmbankingRequest.FirmBankingStatus;
import org.payservice.domain.FirmbankingRequest.FromBankAccountNumber;
import org.payservice.domain.FirmbankingRequest.FromBankName;
import org.payservice.domain.FirmbankingRequest.MoneyAmount;
import org.payservice.domain.FirmbankingRequest.ToBankAccountNumber;
import org.payservice.domain.FirmbankingRequest.ToBankName;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class FirmbankingRequestPersistenceAdapter implements FirmbankingRequestPort, RequestExternalFirmbankingPort {

    private final SpringDataFirmbankingRequestRepository firmbankingRequestRepository;
    @Override
    public FirmbankingRequestJpaEntity createFirmbankingRequest(FromBankName fromBankName,
        FromBankAccountNumber fromBankAccountNumber, ToBankName toBankName, ToBankAccountNumber toBankAccountNumber,
        MoneyAmount moneyAmount, FirmBankingStatus firmBankingStatus) {

        FirmbankingRequestJpaEntity entity = firmbankingRequestRepository.save(new FirmbankingRequestJpaEntity(
            fromBankName.getFromBankName(),
            fromBankAccountNumber.getFromBankAccountNumber(),
            toBankName.getToBankName(),
            toBankAccountNumber.getToBankAccountNumber(),
            moneyAmount.getMoneyAmount(),
            firmBankingStatus.getFirmBankingStatus(),
            UUID.randomUUID()
        ));

        return entity;
    }

    @Override
    public FirmbankingRequestJpaEntity modifyFirmbankingRequest(FirmbankingRequestJpaEntity entity) {
        return firmbankingRequestRepository.save(entity);
    }

    @Override
    public FirmbankingResult requestExternalFirmbanking(ExternalFirmbankingRequest request) {
        //실제로 외부 은행에서 http 통신을 통해서 펌뱅킹 요청

        // 외부 은행에서 온 실제 결과를 페이서비스의 FirmbakingResult로 파싱
        FirmbankingResult result = new FirmbankingResult(0);
        return result;
    }
}
