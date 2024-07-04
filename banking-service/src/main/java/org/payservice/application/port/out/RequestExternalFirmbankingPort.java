package org.payservice.application.port.out;

import org.payservice.adapter.out.external.bank.ExternalFirmbankingRequest;
import org.payservice.adapter.out.external.bank.FirmbankingResult;

public interface RequestExternalFirmbankingPort {
    FirmbankingResult requestExternalFirmbanking(ExternalFirmbankingRequest request);

}
