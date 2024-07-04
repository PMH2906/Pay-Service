package org.payservice.application.port.out;

import org.payservice.adapter.out.persistence.FirmbankingRequestJpaEntity;
import org.payservice.domain.FirmbankingRequest;
import org.payservice.domain.FirmbankingRequest.MoneyAmount;

public interface FirmbankingRequestPort {

    FirmbankingRequestJpaEntity createFirmbankingRequest(
        FirmbankingRequest.FromBankName fromBankName,
        FirmbankingRequest.FromBankAccountNumber fromBankAccountNumber,
        FirmbankingRequest.ToBankName toBankName,
        FirmbankingRequest.ToBankAccountNumber toBankAccountNumber,
        FirmbankingRequest.MoneyAmount moneyAmount,
        FirmbankingRequest.FirmBankingStatus firmBankingStatus
    );

    FirmbankingRequestJpaEntity modifyFirmbankingRequest(FirmbankingRequestJpaEntity entity);
}
