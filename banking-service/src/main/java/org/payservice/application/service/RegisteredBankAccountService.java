package org.payservice.application.service;

import lombok.RequiredArgsConstructor;
import org.payservice.UseCase;
import org.payservice.adapter.out.external.bank.BankAccount;
import org.payservice.adapter.out.external.bank.GetBankAccountRequest;
import org.payservice.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import org.payservice.adapter.out.persistence.RegisteredBankAccountMapper;
import org.payservice.application.port.in.RegisteredBankAccountCommand;
import org.payservice.application.port.in.RegisteredBankAccountUseCase;
import org.payservice.application.port.out.RegisteredBankAccountPort;
import org.payservice.application.port.out.RequestBankAccountInfoPort;
import org.payservice.domain.RegisteredBankAccount;
import org.payservice.domain.RegisteredBankAccount.BankAccountBankName;
import org.payservice.domain.RegisteredBankAccount.BankAccountLinkedStatusIsValid;
import org.payservice.domain.RegisteredBankAccount.BankAccountMembershipId;
import org.payservice.domain.RegisteredBankAccount.BankAccountNumber;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class RegisteredBankAccountService implements RegisteredBankAccountUseCase {

    private final RegisteredBankAccountPort registeredBankAccountPort;
    private final RegisteredBankAccountMapper mapper;
    private final RequestBankAccountInfoPort requestBankAccountInfoPort;

    @Override
    public RegisteredBankAccount registerBankAccount(RegisteredBankAccountCommand command) {

        // 은행 계좌 등록
        command.getMembershipId();

        // 1. 외부 실제 은행에 등록이 가능한 계좌인지 확인
        // 외부와 통신해야함 Biz -> Adapter -> External System

        // 계좌 정보를 기반으로 실제 외부 은행계좌 정보를 GET
        BankAccount accountInfo = requestBankAccountInfoPort.getBankAccountInfo(new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));
        boolean accountIsValid = accountInfo.isValid();

        // 2. 등록가능한 계좌라면, 등록한다. 성공하면, 등록에 성공한 등록 정보를 리턴
        if (accountIsValid) {
            RegisteredBankAccountJpaEntity savedAccountInfo = registeredBankAccountPort.createRegisteredBankAccount(
                new BankAccountMembershipId(command.getMembershipId() + ""),
                new BankAccountBankName(command.getBankName()),
                new BankAccountNumber(command.getBankAccountNumber()),
                new BankAccountLinkedStatusIsValid(command.isLinkedStatusIsValid())
            );

            return mapper.mapToDomainEntity(savedAccountInfo);
        }

        // 2-1. 등록가능하지 않은 계좌라면, 에러를 리턴
        else {
            return null;
        }
    }
}
