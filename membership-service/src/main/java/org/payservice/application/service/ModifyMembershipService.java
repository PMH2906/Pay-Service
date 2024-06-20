package org.payservice.application.service;

import lombok.RequiredArgsConstructor;
import org.payservice.UseCase;
import org.payservice.adapter.out.persistence.MembershipJpaEntity;
import org.payservice.adapter.out.persistence.MembershipMapper;
import org.payservice.application.port.in.ModifyMembershipCommand;
import org.payservice.application.port.in.ModifyMembershipUseCase;
import org.payservice.application.port.out.ModifyMembershipPort;
import org.payservice.domain.Membership;
import org.payservice.domain.Membership.MembershipAddress;
import org.payservice.domain.Membership.MembershipEmail;
import org.payservice.domain.Membership.MembershipId;
import org.payservice.domain.Membership.MembershipIsCorp;
import org.payservice.domain.Membership.MembershipIsValid;
import org.payservice.domain.Membership.MembershipName;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort registerMembershipPort;
    private final MembershipMapper membershipMapper;
    @Override
    public Membership modifyMembership(ModifyMembershipCommand command) {

        // command -> DB

        // biz logic -> DB

        // DB는 external system이므로 port-> adapter를 거쳐 DB와 통신할 수 있음
        MembershipJpaEntity jpaEntity = registerMembershipPort.modifyMembership(
            new MembershipId(command.getMembershipId()),
            new MembershipName(command.getName()),
            new MembershipEmail(command.getEmail()),
            new MembershipAddress(command.getAddress()),
            new MembershipIsValid(command.isValid()),
            new MembershipIsCorp(command.isCorp())
        );

        // entity -> membership
        return membershipMapper.mapToDomainEntity(jpaEntity);
    }
}
