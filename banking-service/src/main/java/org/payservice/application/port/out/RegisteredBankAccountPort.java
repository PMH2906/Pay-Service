package org.payservice.application.port.out;

import org.payservice.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import org.payservice.domain.RegisteredBankAccount;
import org.payservice.domain.RegisteredBankAccount.BankAccountLinkedStatusIsValid;
import org.payservice.domain.RegisteredBankAccount.BankAccountBankName;
import org.payservice.domain.RegisteredBankAccount.BankAccountMembershipId;

public interface RegisteredBankAccountPort {

    RegisteredBankAccountJpaEntity createRegisteredBankAccount(
        BankAccountMembershipId membershipId
        , BankAccountBankName bankName
        , RegisteredBankAccount.BankAccountNumber bankAccountNumber
        , BankAccountLinkedStatusIsValid linkedStatusIsValid
    );
}
