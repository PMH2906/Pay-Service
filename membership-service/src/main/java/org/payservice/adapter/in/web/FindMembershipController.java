package org.payservice.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.payservice.application.port.in.FindMembershipCommand;
import org.payservice.application.port.in.FindMembershipUseCase;
import org.payservice.common.WebAdapter;
import org.payservice.domain.Membership;
import org.payservice.domain.Membership.MembershipId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * HTTP 요청과의 상호작용을 관리하는 인바운드어댑터
 * **/
@RestController
@RequiredArgsConstructor
@WebAdapter
public class FindMembershipController {

    private final FindMembershipUseCase findMembershipUseCase;

    @GetMapping(path = "/membership/{membershipId}")
    ResponseEntity<Membership> findMembershipById(@PathVariable String membershipId){

        FindMembershipCommand command = FindMembershipCommand.builder()
            .membershipId(membershipId)
            .build();

        Membership membership = findMembershipUseCase.findMembership(command);

        return ResponseEntity.ok(membership);
    }
}
