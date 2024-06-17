package org.payservice.application.port.in;

import org.payservice.domain.Membership;

public interface FindMembershipUseCase {

    Membership findMembership(FindMembershipCommand command);
}
