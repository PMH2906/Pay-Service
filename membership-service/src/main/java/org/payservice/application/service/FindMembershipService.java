package org.payservice.application.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.payservice.adapter.out.persistence.MembershipJpaEntity;
import org.payservice.adapter.out.persistence.MembershipMapper;
import org.payservice.application.port.in.FindMembershipCommand;
import org.payservice.application.port.in.FindMembershipUseCase;
import org.payservice.application.port.out.FindMembershipPort;
import org.payservice.common.UseCase;
import org.payservice.domain.Membership;
import org.payservice.domain.Membership.MembershipId;

@RequiredArgsConstructor
@UseCase
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;
    private final MembershipMapper membershipMapper;
    @Override
    public Membership findMembership(FindMembershipCommand command) {
        MembershipJpaEntity membershipJpaEntity = findMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));
        return membershipMapper.mapToDomainEntity(membershipJpaEntity);
    }
}
