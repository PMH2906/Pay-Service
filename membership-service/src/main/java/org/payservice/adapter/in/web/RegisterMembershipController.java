package org.payservice.adapter.in.web;

import lombok.RequiredArgsConstructor;

import org.payservice.application.port.in.RegisterMembershipCommand;
import org.payservice.application.port.in.RegisterMembershipUseCase;
import org.payservice.common.WebAdapter;
import org.payservice.domain.Membership;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * HTTP 요청과의 상호작용을 관리하는 인바운드어댑터
 * **/
@RestController
@RequiredArgsConstructor
@WebAdapter
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;
    @PostMapping(path = "/membership/register")
    Membership registerMembership(@RequestBody RegisterMembershipRequest request){

        // request -> Command

        // request로 받은 데이터를 Command로 추상화하여 사용한다. 이는 request가 수정되어도 영향을 안 받기위해서 하는 것이다.
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
            .name(request.getName())
            .address(request.getAddress())
            .email(request.getEmail())
            .isValid(true)
            .isCorp(request.isCorp())
            .build();

        return registerMembershipUseCase.registerMembership(command);

    }
}