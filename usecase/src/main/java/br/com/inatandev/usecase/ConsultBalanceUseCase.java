package br.com.inatandev.usecase;

import br.com.inatandev.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceUseCase {

    BigDecimal consult(Wallet wallet);
}
