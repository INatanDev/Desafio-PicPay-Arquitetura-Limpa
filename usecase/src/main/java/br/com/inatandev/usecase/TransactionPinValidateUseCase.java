package br.com.inatandev.usecase;

import br.com.inatandev.core.domain.TransactionPin;
import br.com.inatandev.core.exception.PinException;
import br.com.inatandev.core.exception.TransferException;

public interface TransactionPinValidateUseCase {

    Boolean validate(TransactionPin transactionPin) throws TransferException, PinException;
}
