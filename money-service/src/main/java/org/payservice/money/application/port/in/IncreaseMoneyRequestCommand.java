package org.payservice.money.application.port.in;

import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.payservice.SelfValidating;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class IncreaseMoneyRequestCommand extends SelfValidating<IncreaseMoneyRequestCommand> {

    @NotNull
    private final String targetMembershipId;

    @NotNull
    private final int amount;


    public IncreaseMoneyRequestCommand(@NotNull String targetMembershipId, @NotNull int amount) {
        this.targetMembershipId = targetMembershipId;
        this.amount = amount;
        this.validateSelf();
    }
}
