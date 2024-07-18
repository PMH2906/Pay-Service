package org.payservice.application.port.out;

public interface GetMembershipPort {

    public MembershipStatus getMembership(String membershipId);
}
