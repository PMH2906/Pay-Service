package org.payservice.application.service;

import lombok.RequiredArgsConstructor;
import org.payservice.adapter.out.persistence.MembershipJpaEntity;
import org.payservice.adapter.out.persistence.MembershipMapper;
import org.payservice.application.port.in.RegisterMembershipCommand;
import org.payservice.application.port.in.RegisterMembershipUseCase;
import org.payservice.application.port.out.RegisterMembershipPort;
import org.payservice.common.UseCase;
import org.payservice.domain.Membership;
import org.payservice.domain.Membership.MembershipAddress;
import org.payservice.domain.Membership.MembershipEmail;
import org.payservice.domain.Membership.MembershipIsCorp;
import org.payservice.domain.Membership.MembershipIsValid;
import org.payservice.domain.Membership.MembershipName;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;
    private final MembershipMapper membershipMapper;
    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {

        // command -> DB

        // biz logic -> DB

        // DB는 external system이므로 port-> adapter를 거쳐 DB와 통신할 수 있음
        MembershipJpaEntity jpaEntity = registerMembershipPort.createMembership(
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
