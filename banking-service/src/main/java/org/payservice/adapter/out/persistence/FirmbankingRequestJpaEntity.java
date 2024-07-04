package org.payservice.adapter.out.persistence;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="request_firmbanking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirmbankingRequestJpaEntity {
    @Id
    @GeneratedValue
    private Long firmbankingRequestId;
    private String fromBankName;
    private String fromBankAccountNumber;
    private String toBankName;
    private String toBankAccountNumber;
    private int moneyAccount;
    private int firmBankingStatus; // 0:요청, 1: 완료, 2: 실패
    private UUID uuid;

    public FirmbankingRequestJpaEntity(String fromBankName, String fromBankAccountNumber, String toBankName,
        String toBankAccountNumber, int moneyAccount, int firmBankingStatus, UUID uuid) {
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.moneyAccount = moneyAccount;
        this.firmBankingStatus = firmBankingStatus;
        this.uuid=uuid;
    }

    @Override
    public String toString() {
        return "RequestFirmbankingJpaEntity{" +
            "fromBankName='" + fromBankName + '\'' +
            ", fromBankAccountNumber='" + fromBankAccountNumber + '\'' +
            ", toBankName='" + toBankName + '\'' +
            ", toBankAccountNumber='" + toBankAccountNumber + '\'' +
            '}';
    }
}