package org.payservice.application.port.out;

import org.payservice.adapter.out.persistence.MembershipJpaEntity;
import org.payservice.domain.Membership;
import org.payservice.domain.Membership.MembershipName;

public interface ModifyMembershipPort {

    MembershipJpaEntity modifyMembership(
        Membership.MembershipId membershipId
        , Membership.MembershipName membershipName
        , Membership.MembershipEmail membershipEmail
        , Membership.MembershipAddress membershipAddress
        , Membership.MembershipIsValid membershipIsValid
        , Membership.MembershipIsCorp membershipIsCorp
    );
}
