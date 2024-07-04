package org.payservice.money.application.port.out;

import org.payservice.money.adapter.out.persistence.MemberMoneyJpaEntity;
import org.payservice.money.adapter.out.persistence.MoneyChangingRequestJpaEntity;
import org.payservice.money.domain.MemberMoney;
import org.payservice.money.domain.MoneyChangingRequest;

public interface IncreaseMoneyPort {

    MoneyChangingRequestJpaEntity createMoneyChangingRequest(
            MoneyChangingRequest.TargetMembershipId targetMembershipId,
            MoneyChangingRequest.MoneyChangingType moneyChangingType,
            MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
            MoneyChangingRequest.MoneyChangingStatus moneyChangingStatus,
            MoneyChangingRequest.Uuid uuid
    );

    MemberMoneyJpaEntity increaseMoney(
            MemberMoney.MembershipId memberId,
            int increaseMoneyAmount
    );
}
