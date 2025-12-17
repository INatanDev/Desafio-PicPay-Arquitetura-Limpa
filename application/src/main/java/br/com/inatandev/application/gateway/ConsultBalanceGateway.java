package br.com.inatandev.application.gateway;

import br.com.inatandev.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceGateway {

    BigDecimal consult(Wallet wallet);
}
