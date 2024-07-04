package org.payservice.application.port.in;

import org.payservice.domain.FirmbankingRequest;

/**
 * 비즈니스 로직과 연결되는 인터페이스 역할
 * **/
public interface RequestFirmbankingUseCase {

    FirmbankingRequest requestFirmbanking(FirmbankingRequestCommand command);
}
