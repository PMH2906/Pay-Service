package org.payservice.adapter.out.external.bank;

import lombok.RequiredArgsConstructor;
import org.payservice.ExternalSystemAdapter;
import org.payservice.PersistenceAdapter;
import org.payservice.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import org.payservice.adapter.out.persistence.SpringDataRegisteredBankAccountRepository;
import org.payservice.application.port.out.RegisteredBankAccountPort;
import org.payservice.application.port.out.RequestBankAccountInfoPort;
import org.payservice.domain.RegisteredBankAccount.BankAccountBankName;
import org.payservice.domain.RegisteredBankAccount.BankAccountLinkedStatusIsValid;
import org.payservice.domain.RegisteredBankAccount.BankAccountMembershipId;
import org.payservice.domain.RegisteredBankAccount.BankAccountNumber;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort {

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request) {

        // 원래는 외부 API와 통신해서 계좌 정보를 조회해야함
        return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
    }
}
