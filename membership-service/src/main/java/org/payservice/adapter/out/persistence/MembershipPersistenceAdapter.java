package org.payservice.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.payservice.PersistenceAdapter;
import org.payservice.application.port.out.FindMembershipPort;
import org.payservice.application.port.out.ModifyMembershipPort;
import org.payservice.application.port.out.RegisterMembershipPort;
import org.payservice.domain.Membership.MembershipAddress;
import org.payservice.domain.Membership.MembershipEmail;
import org.payservice.domain.Membership.MembershipId;
import org.payservice.domain.Membership.MembershipIsCorp;
import org.payservice.domain.Membership.MembershipIsValid;
import org.payservice.domain.Membership.MembershipName;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public MembershipJpaEntity createMembership(MembershipName membershipName, MembershipEmail membershipEmail,
        MembershipAddress membershipAddress, MembershipIsValid membershipIsValid, MembershipIsCorp membershipIsCorp) {

        return membershipRepository.save(
            new MembershipJpaEntity(
                membershipName.getNameValue(),
                membershipEmail.getEmailValue(),
                membershipAddress.getAddressValue(),
                membershipIsValid.isValidValue(),
                membershipIsCorp.isCorpValue()
            )
        );
    }

    @Override
    public MembershipJpaEntity findMembership(MembershipId membershipId) {
        return membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()));
    }

    @Override
    public MembershipJpaEntity modifyMembership(MembershipId membershipId, MembershipName membershipName,
        MembershipEmail membershipEmail, MembershipAddress membershipAddress, MembershipIsValid membershipIsValid,
        MembershipIsCorp membershipIsCorp) {

        MembershipJpaEntity entity = membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()));

        entity.setName(membershipName.getNameValue());
        entity.setAddress(membershipAddress.getAddressValue());
        entity.setCorp(membershipIsCorp.isCorpValue());
        entity.setValid(membershipIsValid.isValidValue());
        entity.setEmail(membershipEmail.getEmailValue());

        return membershipRepository.save(entity);
    }
}
