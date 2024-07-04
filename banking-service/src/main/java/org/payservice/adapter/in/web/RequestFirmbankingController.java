package org.payservice.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.payservice.WebAdapter;
import org.payservice.application.port.in.FirmbankingRequestCommand;
import org.payservice.application.port.in.RequestFirmbankingUseCase;
import org.payservice.domain.FirmbankingRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * HTTP 요청과의 상호작용을 관리하는 인바운드어댑터
 * **/
@RestController
@RequiredArgsConstructor
@WebAdapter
public class RequestFirmbankingController {

    private final RequestFirmbankingUseCase requestFirmbankingUseCase;
    @PostMapping(path = "/banking/firmbanking/request")
    FirmbankingRequest registerMembership(@RequestBody RequestFirmbakingRequest request){

        // request -> Command

        // request로 받은 데이터를 Command로 추상화하여 사용한다. 이는 request가 수정되어도 영향을 안 받기위해서 하는 것이다.
        FirmbankingRequestCommand command = FirmbankingRequestCommand.builder()
            .fromBankName(request.getFromBankName())
            .fromBankAccountNumber(request.getFromBankAccountNumber())
            .toBankName(request.getToBankName())
            .toBankNameAccountNumber(request.getToBankAccountNumber())
            .moneyAmount(request.getMoneyAmount())
            .build();

        return requestFirmbankingUseCase.requestFirmbanking(command);
    }
}