package org.payservice.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.payservice.PersistenceAdapter;
import org.payservice.application.port.out.RegisteredBankAccountPort;
import org.payservice.domain.RegisteredBankAccount.BankAccountNumber;
import org.payservice.domain.RegisteredBankAccount.BankAccountBankName;
import org.payservice.domain.RegisteredBankAccount.BankAccountLinkedStatusIsValid;
import org.payservice.domain.RegisteredBankAccount.BankAccountMembershipId;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisteredBankAccountPersistenceAdapter implements RegisteredBankAccountPort{

    private final SpringDataRegisteredBankAccountRepository bankAccountRepository;

    @Override
    public RegisteredBankAccountJpaEntity createRegisteredBankAccount(BankAccountMembershipId membershipId, BankAccountBankName bankName, BankAccountNumber bankAccountNumber, BankAccountLinkedStatusIsValid linkedStatusIsValid) {

        return bankAccountRepository.save(
            new RegisteredBankAccountJpaEntity(
                membershipId.getMembershipId(),
                bankName.getBankName(),
                bankAccountNumber.getBankAccountNumber(),
                linkedStatusIsValid.isLinkedStatusIsValid()
            )
        );
    }
}
