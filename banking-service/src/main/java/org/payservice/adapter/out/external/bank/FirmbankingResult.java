package org.payservice.adapter.out.external.bank;

import lombok.Data;

@Data
public class FirmbankingResult {

    private int resultCode;

    public FirmbankingResult(int resultCode) {
        this.resultCode = resultCode;
    }
}
