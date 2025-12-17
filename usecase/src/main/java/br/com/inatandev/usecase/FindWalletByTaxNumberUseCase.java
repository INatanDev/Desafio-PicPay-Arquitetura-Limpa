package br.com.inatandev.usecase;

import br.com.inatandev.core.domain.Wallet;
import br.com.inatandev.core.exception.NotFoundException;

public interface FindWalletByTaxNumberUseCase {

    Wallet findByTaxNumber(String taxNumber) throws Exception;
}
