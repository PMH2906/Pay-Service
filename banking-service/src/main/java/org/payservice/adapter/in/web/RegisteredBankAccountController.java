package org.payservice.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.payservice.WebAdapter;
import org.payservice.application.port.in.RegisteredBankAccountCommand;
import org.payservice.application.port.in.RegisteredBankAccountUseCase;
import org.payservice.domain.RegisteredBankAccount;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * HTTP 요청과의 상호작용을 관리하는 인바운드어댑터
 * **/
@RestController
@RequiredArgsConstructor
@WebAdapter
public class RegisteredBankAccountController {

    private final RegisteredBankAccountUseCase registeredBankAccountUseCase;
    @PostMapping(path = "/banking/account/register")
    RegisteredBankAccount registerMembership(@RequestBody RegisteredBankAccountRequest request){

        // request -> Command

        // request로 받은 데이터를 Command로 추상화하여 사용한다. 이는 request가 수정되어도 영향을 안 받기위해서 하는 것이다.
        RegisteredBankAccountCommand command = RegisteredBankAccountCommand.builder()
            .membershipId(request.getMembershipId())
            .bankName(request.getBankName())
            .bankAccountNumber(request.getBankAccountNumber())
            .linkedStatusIsValid(request.isLinkedStatusIsValid())
            .build();

        RegisteredBankAccount registeredBankAccount = registeredBankAccountUseCase.registerBankAccount(command);
        if(registeredBankAccount==null) {

            // ToDo : Error Handler
            return null;
        }
        return registeredBankAccount;
    }
}