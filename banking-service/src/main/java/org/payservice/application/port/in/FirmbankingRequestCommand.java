package org.payservice.application.port.in;

import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.payservice.SelfValidating;

@Builder
@Data
@EqualsAndHashCode(callSuper = false) // Equals와 HashCode 함수를 사용할 때 부모 필드까지 같은지 비교한 후 모두 같아야지 같지만, false를 사용하면 부모까지 같지 않아도 된다.
public class FirmbankingRequestCommand extends SelfValidating<FirmbankingRequestCommand> {

    @NotNull
    private final String fromBankName;
    @NotNull
    private final String fromBankAccountNumber;
    @NotNull
    private final String toBankName;
    @NotNull
    private final String toBankNameAccountNumber;
    private final int moneyAmount;

    public FirmbankingRequestCommand(String fromBankName, String fromBankAccountName, String toBankName,
        String toBankNameAccountName, int moneyAmount) {
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountName;
        this.toBankName = toBankName;
        this.toBankNameAccountNumber = toBankNameAccountName;
        this.moneyAmount = moneyAmount;
    }
}
