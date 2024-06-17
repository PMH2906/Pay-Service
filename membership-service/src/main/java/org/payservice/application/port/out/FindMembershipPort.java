package org.payservice.application.port.out;

import org.payservice.adapter.out.persistence.MembershipJpaEntity;
import org.payservice.application.port.in.FindMembershipCommand;
import org.payservice.domain.Membership;
import org.payservice.domain.Membership.MembershipId;

public interface FindMembershipPort {

    MembershipJpaEntity findMembership(Membership.MembershipId membershipId);
}
