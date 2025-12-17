package br.com.inatandev.application.usercaseimpl;

import br.com.inatandev.application.gateway.ConsultBalanceGateway;
import br.com.inatandev.core.domain.Wallet;
import br.com.inatandev.usecase.ConsultBalanceUseCase;

import java.math.BigDecimal;

public class ConsultBalanceUseCaseImpl implements ConsultBalanceUseCase {

    private ConsultBalanceGateway consultBalanceGateway;

    public ConsultBalanceUseCaseImpl(ConsultBalanceGateway consultBalanceGateway) {
        this.consultBalanceGateway = consultBalanceGateway;
    }

    @Override
    public BigDecimal consult(Wallet wallet) {
        return consultBalanceGateway.consult(wallet);
    }
}
