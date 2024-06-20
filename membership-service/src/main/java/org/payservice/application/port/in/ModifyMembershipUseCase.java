package org.payservice.application.port.in;

import org.payservice.domain.Membership;

/**
 * 비즈니스 로직과 연결되는 인터페이스 역할
 * **/
public interface ModifyMembershipUseCase {

    Membership modifyMembership(ModifyMembershipCommand command);
}
