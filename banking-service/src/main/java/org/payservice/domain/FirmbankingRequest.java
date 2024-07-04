package org.payservice.domain;

import java.util.UUID;
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
public class FirmbankingRequest {
    private final Long firmbankingRequestId;
    private final String fromBankName;
    private final String fromBankAccountNumber;
    private final String toBankName;
    private final String toBankAccountNumber;
    private final int moneyAmount;
    private final int firmBankingStatus;
    private final UUID uuid; // 0: 요청, 1:완료, 2:실패

    public static FirmbankingRequest generateFirmbankingRequest(
        FirmbankingRequestId firmbankingRequestId,
        FromBankName fromBankName,
        FromBankAccountNumber fromBankAccountNumber,
        ToBankName toBankName,
        ToBankAccountNumber toBankAccountNumber,
        MoneyAmount moneyAmount,
        FirmBankingStatus firmBankingStatus,
        UUID uuid
    ) {
        return new FirmbankingRequest(
            firmbankingRequestId.firmbankingRequestId,
            fromBankName.fromBankName,
            fromBankAccountNumber.fromBankAccountNumber,
            toBankName.toBankName,
            toBankAccountNumber.toBankAccountNumber,
            moneyAmount.moneyAmount,
            firmBankingStatus.firmBankingStatus,
            uuid
        );
    }

    @Value
    public static class FirmbankingRequestId {

        Long firmbankingRequestId;

        public FirmbankingRequestId(Long value) {
            this.firmbankingRequestId=value;
        }
    }

    @Value
    public static class FromBankName {

        String fromBankName;

        public FromBankName(String value) {
            this.fromBankName=value;
        }
    }

    @Value
    public static class FromBankAccountNumber {

        String fromBankAccountNumber;

        public FromBankAccountNumber(String value) {
            this.fromBankAccountNumber=value;
        }
    }

    @Value
    public static class ToBankName {

        String toBankName;

        public ToBankName(String value) {
            this.toBankName=value;
        }
    }

    @Value
    public static class ToBankAccountNumber {

        String toBankAccountNumber;

        public ToBankAccountNumber(String value) {
            this.toBankAccountNumber=value;
        }
    }
    @Value
    public static class MoneyAmount {

        int moneyAmount;

        public MoneyAmount(int value) {
            this.moneyAmount=value;
        }
    }
    @Value
    public static class FirmBankingStatus {

        int firmBankingStatus;

        public FirmBankingStatus(int value) {
            this.firmBankingStatus=value;
        }
    }
}