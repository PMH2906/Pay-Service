package org.payservice.application.port.in;

import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.payservice.SelfValidating;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class FindMembershipCommand extends SelfValidating<FindMembershipCommand> {

    @NotNull
    private String membershipId;

    public FindMembershipCommand(String membershipId) {
        this.membershipId = membershipId;
        this.validateSelf();
    }
}
