package br.com.inatandev.application.gateway;

import br.com.inatandev.core.domain.Transaction;

public interface TransactionValidateGateway {

    Boolean validate(Transaction transaction);
}
