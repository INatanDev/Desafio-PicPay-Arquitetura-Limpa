package br.com.inatandev.application.gateway;

import br.com.inatandev.core.domain.Wallet;

public interface FindWalletByTaxNumberGateway {

    Wallet findByTaxNumber(String taxNumber) throws Exception;
}
