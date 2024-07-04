package org.payservice.adapter.out.persistence;

import org.payservice.domain.RegisteredBankAccount;
import org.payservice.domain.RegisteredBankAccount.BankAccountId;
import org.payservice.domain.RegisteredBankAccount.BankAccountLinkedStatusIsValid;
import org.payservice.domain.RegisteredBankAccount.BankAccountBankName;
import org.payservice.domain.RegisteredBankAccount.BankAccountMembershipId;
import org.springframework.stereotype.Component;

@Component
public class RegisteredBankAccountMapper {

    // Entity의 값을 Domain으로 변환
    public RegisteredBankAccount mapToDomainEntity(
        RegisteredBankAccountJpaEntity registeredBankAccount) {
        return RegisteredBankAccount.generateRegisteredBankAccount(
            new BankAccountId(registeredBankAccount.getRegisteredBankAccountId()+""),
            new BankAccountMembershipId(registeredBankAccount.getMembershipId()),
            new BankAccountBankName(registeredBankAccount.getBankName()),
            new RegisteredBankAccount.BankAccountNumber(registeredBankAccount.getBankAccountNumber()),
            new BankAccountLinkedStatusIsValid(registeredBankAccount.isLinkedStatusIsValid())
        );
    }
}
