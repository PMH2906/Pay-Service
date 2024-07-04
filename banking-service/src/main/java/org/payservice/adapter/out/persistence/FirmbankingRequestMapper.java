package org.payservice.adapter.out.persistence;

import java.util.UUID;
import org.payservice.domain.FirmbankingRequest;
import org.payservice.domain.FirmbankingRequest.FirmBankingStatus;
import org.payservice.domain.FirmbankingRequest.FirmbankingRequestId;
import org.payservice.domain.FirmbankingRequest.FromBankAccountNumber;
import org.payservice.domain.FirmbankingRequest.FromBankName;
import org.payservice.domain.FirmbankingRequest.MoneyAmount;
import org.payservice.domain.FirmbankingRequest.ToBankAccountNumber;
import org.payservice.domain.FirmbankingRequest.ToBankName;
import org.springframework.stereotype.Component;

@Component
public class FirmbankingRequestMapper {

    // Entity의 값을 Domain으로 변환
    public FirmbankingRequest mapToDomainEntity(
        FirmbankingRequestJpaEntity requestFirmbankingJpaEntity, UUID uuid) {
        return FirmbankingRequest.generateFirmbankingRequest(
            new FirmbankingRequestId(requestFirmbankingJpaEntity.getFirmbankingRequestId()),
            new FromBankName(requestFirmbankingJpaEntity.getFromBankName()),
            new FromBankAccountNumber(requestFirmbankingJpaEntity.getFromBankAccountNumber()),
            new ToBankName(requestFirmbankingJpaEntity.getToBankName()),
            new ToBankAccountNumber(requestFirmbankingJpaEntity.getToBankAccountNumber()),
            new MoneyAmount(requestFirmbankingJpaEntity.getMoneyAccount()),
            new FirmBankingStatus(requestFirmbankingJpaEntity.getFirmBankingStatus()),
            uuid
        );
    }
}
