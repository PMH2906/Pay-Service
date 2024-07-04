package org.payservice.application.port.out;

import org.payservice.adapter.out.external.bank.BankAccount;
import org.payservice.adapter.out.external.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {

    BankAccount getBankAccountInfo(GetBankAccountRequest request);

}
