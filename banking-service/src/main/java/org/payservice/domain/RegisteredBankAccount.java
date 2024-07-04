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
public class RegisteredBankAccount {
    private final String bankAccountId;
    private final String membershipId;
    private final String bankName;
    private final String bankAccountNumber;
    private final boolean linkedStatusIsValid;

    public static RegisteredBankAccount generateRegisteredBankAccount(
        BankAccountId registeredBankAccountId,
        BankAccountMembershipId membershipId,
        BankAccountBankName bankName,
        BankAccountNumber bankAccountNumber,
        BankAccountLinkedStatusIsValid linkedStatusIsValid
    ) {
        return new RegisteredBankAccount(
            registeredBankAccountId.bankAccountId,
            membershipId.membershipId,
            bankName.bankName,
            bankAccountNumber.bankAccountNumber,
            linkedStatusIsValid.linkedStatusIsValid
        );
    }

    @Value
    public static class BankAccountId {

        String bankAccountId;

        public BankAccountId(String value) {
            this.bankAccountId=value;
        }
    }

    @Value
    public static class BankAccountMembershipId {

        String membershipId;

        public BankAccountMembershipId(String value) {
            this.membershipId=value;
        }
    }

    @Value
    public static class BankAccountBankName {

        String bankName;

        public BankAccountBankName(String value) {
            this.bankName=value;
        }
    }

    @Value
    public static class BankAccountNumber {

        String bankAccountNumber;

        public BankAccountNumber(String value) {
            this.bankAccountNumber=value;
        }
    }

    @Value
    public static class BankAccountLinkedStatusIsValid {

        boolean linkedStatusIsValid;

        public BankAccountLinkedStatusIsValid(boolean value) {
            this.linkedStatusIsValid=value;
        }
    }

}