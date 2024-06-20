package org.payservice.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.payservice.WebAdapter;
import org.payservice.application.port.in.ModifyMembershipCommand;
import org.payservice.application.port.in.ModifyMembershipUseCase;
import org.payservice.domain.Membership;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * HTTP 요청과의 상호작용을 관리하는 인바운드어댑터
 * **/
@RestController
@RequiredArgsConstructor
@WebAdapter
public class ModifyMembershipController {

    private final ModifyMembershipUseCase modifyMembershipUseCase;

    @PatchMapping(path = "/membership/modify")
    ResponseEntity<Membership> modifyMembershipById(@RequestBody ModifyMembershipRequest request){

        ModifyMembershipCommand command = ModifyMembershipCommand.builder()
            .membershipId(request.getMembershipId())
            .name(request.getName())
            .address(request.getAddress())
            .email(request.getEmail())
            .isCorp(request.isCorp())
            .isValid(request.isValid())
            .build();

        Membership membership = modifyMembershipUseCase.modifyMembership(command);

        return ResponseEntity.ok(membership);
    }
}
