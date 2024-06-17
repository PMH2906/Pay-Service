package org.payservice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

/**
 * Membership 클래스는 오염이 되면 안되는 클래스로, Private 접근제어자와 Getter로 접근가능하게끔 설정함.
 * 외부 생성은 public generateMember 메서드로 생성가능 -> 보호
 * **/
@AllArgsConstructor(access = AccessLevel.PRIVATE) // AllArgsConstructor 접급제어자를 PRIVATE으로 설정
@Getter
public class Membership {
    private final String membershipId;
    private final String name;
    private final String email;
    private final String address;
    private final boolean isValid;
    private final boolean isCorp;

    public static Membership generateMember(
        MembershipId membershipId,
        MembershipName membershipName,
        MembershipEmail membershipEmail,
        MembershipAddress membershipAddress,
        MembershipIsValid membershipIsValid,
        MembershipIsCorp membershipIsCorp

    ) {
        return new Membership(
            membershipId.membershipId,
            membershipName.nameValue,
            membershipEmail.emailValue,
            membershipAddress.addressValue,
            membershipIsValid.isValidValue,
            membershipIsCorp.isCorpValue
        );
    }

    @Value
    public static class MembershipId {

        String membershipId;

        public MembershipId(String value) {
            this.membershipId=value;
        }
    }

    @Value
    public static class MembershipName {

        String nameValue;

        public MembershipName(String value) {
            this.nameValue=value;
        }
    }

    @Value
    public static class MembershipEmail {

        String emailValue;

        public MembershipEmail(String value) {
            this.emailValue=value;
        }
    }

    @Value
    public static class MembershipAddress {

        String addressValue;

        public MembershipAddress(String value) {
            this.addressValue=value;
        }
    }

    @Value
    public static class MembershipIsValid {

        boolean isValidValue;

        public MembershipIsValid(boolean value) {
            this.isValidValue=value;
        }
    }

    @Value
    public static class MembershipIsCorp {

        boolean isCorpValue;

        public MembershipIsCorp(boolean value) {
            this.isCorpValue=value;
        }
    }
}