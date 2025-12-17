package br.com.inatandev.application.gateway;

import br.com.inatandev.core.domain.Transaction;

public interface CreateTransactionGateway {

    Transaction create(Transaction transaction);
}
