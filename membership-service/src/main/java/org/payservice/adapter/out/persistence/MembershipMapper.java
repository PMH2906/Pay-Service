package org.payservice.adapter.out.persistence;

import org.payservice.domain.Membership;
import org.springframework.stereotype.Component;

@Component
public class MembershipMapper {

    // Entity의 값을 Domain으로 변환
    public Membership mapToDomainEntity(
        MembershipJpaEntity membership) {
        System.out.println(membership.toString());
        return Membership.generateMember(
            new Membership.MembershipId(membership.getMembershipId()+""),
            new Membership.MembershipName(membership.getName()),
            new Membership.MembershipEmail(membership.getEmail()),
            new Membership.MembershipAddress(membership.getAddress()),
            new Membership.MembershipIsValid(membership.isValid()),
            new Membership.MembershipIsCorp(membership.isCorp())
        );
    }
}
