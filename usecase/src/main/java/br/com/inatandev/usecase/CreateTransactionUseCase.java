package br.com.inatandev.usecase;

import br.com.inatandev.core.domain.Transaction;
import br.com.inatandev.core.exception.TransferException;

public interface CreateTransactionUseCase {

    Transaction create(Transaction transaction) throws Exception;
}
