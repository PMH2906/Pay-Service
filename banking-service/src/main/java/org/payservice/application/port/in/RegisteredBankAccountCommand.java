package org.payservice.application.port.in;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.payservice.SelfValidating;

@Builder
@Data
@EqualsAndHashCode(callSuper = false) // Equals와 HashCode 함수를 사용할 때 부모 필드까지 같은지 비교한 후 모두 같아야지 같지만, false를 사용하면 부모까지 같지 않아도 된다.
public class RegisteredBankAccountCommand extends SelfValidating<RegisteredBankAccountCommand> {

    @NotNull
    private final String membershipId;
    @NotNull
    private final String bankName;
    @NotNull
    @NotBlank
    private final String bankAccountNumber;
    private final boolean linkedStatusIsValid;

    public RegisteredBankAccountCommand(String membershipId, String bankName, String bankAccountNumber,
        boolean linkedStatusIsValid) {
        this.membershipId = membershipId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.linkedStatusIsValid = linkedStatusIsValid;
        this.validateSelf(); // 필드 모두에 null이 들어온 순간 validateSelf() 메서드를 통해서 exception 던진다.
    }
}
