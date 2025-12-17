package br.com.inatandev.application.gateway;

import br.com.inatandev.core.domain.TransactionPin;

public interface TransactionPinValidateGateway {

    Boolean validate(TransactionPin transactionPin);
}
