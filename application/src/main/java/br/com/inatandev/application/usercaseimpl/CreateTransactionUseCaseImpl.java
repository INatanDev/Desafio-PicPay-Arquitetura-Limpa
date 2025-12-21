package br.com.inatandev.application.usercaseimpl;

import br.com.inatandev.application.gateway.CreateTransactionGateway;
import br.com.inatandev.core.domain.Transaction;
import br.com.inatandev.core.exception.TransferException;
import br.com.inatandev.core.exception.enums.ErrorCodeEnum;
import br.com.inatandev.usecase.CreateTransactionUseCase;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

    private CreateTransactionGateway createTransactionGateway;

    public CreateTransactionUseCaseImpl(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction create(Transaction transaction) throws Exception {
        var transactionSaved = createTransactionGateway.create(transaction);

        if(transactionSaved == null){
            throw new TransferException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        return transactionSaved;
    }
}
