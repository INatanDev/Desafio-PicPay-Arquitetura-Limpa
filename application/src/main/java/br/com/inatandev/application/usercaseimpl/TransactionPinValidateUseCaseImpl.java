package br.com.inatandev.application.usercaseimpl;

import br.com.inatandev.application.gateway.TransactionPinValidateGateway;
import br.com.inatandev.core.domain.TransactionPin;
import br.com.inatandev.core.exception.PinException;
import br.com.inatandev.core.exception.enums.ErrorCodeEnum;
import br.com.inatandev.usecase.TransactionPinValidateUseCase;
import br.com.inatandev.usecase.UpdateTransactionPinUseCase;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {

    private TransactionPinValidateGateway transactionPinValidateGateway;

    private UpdateTransactionPinUseCase updateTransactionPinUseCase;

    public TransactionPinValidateUseCaseImpl(TransactionPinValidateGateway transactionPinValidateGateway, UpdateTransactionPinUseCase updateTransactionPinUseCase) {
        this.transactionPinValidateGateway = transactionPinValidateGateway;
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin) throws PinException {
        if (transactionPin.getBlocked()) throw new PinException(ErrorCodeEnum.PIN0001.getMessage(), ErrorCodeEnum.PIN0001.getCode());

        if(!transactionPinValidateGateway.validate(transactionPin)){
            transactionPin.setAttempt();
            var transactionPinUpdated = updateTransactionPinUseCase.updateTransactionPin(transactionPin);
            throw new PinException(ErrorCodeEnum.pin0002GetMessage(transactionPinUpdated.getAttempt()), ErrorCodeEnum.PIN0002.getCode());
        }

        if(transactionPin.getAttempt() < 3) {
            transactionPin.restaureAttempt();
            updateTransactionPinUseCase.updateTransactionPin(transactionPin);
        }

        return true;
    }
}
