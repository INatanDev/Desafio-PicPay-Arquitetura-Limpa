package br.com.inatandev.application.usercaseimpl;

import br.com.inatandev.application.gateway.TransaferGateway;
import br.com.inatandev.core.domain.Transaction;
import br.com.inatandev.core.domain.Wallet;
import br.com.inatandev.core.exception.*;
import br.com.inatandev.core.exception.enums.ErrorCodeEnum;
import br.com.inatandev.usecase.*;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {

    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;

    private TransactionValidateUseCase transactionValidateUseCase;

    private CreateTransactionUseCase createTransactionUseCase;

    private TransaferGateway  transaferGateway;

    private UserNotificationUseCase userNotificationUseCase;

    private TransactionPinValidateUseCase transactionPinValidateUseCase;

    public TransferUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, CreateTransactionUseCase createTransactionUseCase, TransaferGateway transaferGateway, UserNotificationUseCase userNotificationUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transaferGateway = transaferGateway;
        this.userNotificationUseCase = userNotificationUseCase;
    }

    @Override
    public Boolean transfer(String fromTaxNumber,String toTaxNumber, BigDecimal value, String pin) throws Exception {
        Wallet from = findWalletByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.findByTaxNumber(toTaxNumber);

        transactionPinValidateUseCase.validate(from.getTransactionPin());

        from.transfer(value);
        to.receiveTransfer(value);

        var transaction = createTransactionUseCase.create(new Transaction(from, to, value ));

        transactionValidateUseCase.validate(transaction);

        if(!transaferGateway.Transfer(transaction)){
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        if (!userNotificationUseCase.notificate(transaction, to.getUser().getEmail())){
            throw new NotificationException(ErrorCodeEnum.NO0001.getMessage(), ErrorCodeEnum.NO0001.getCode());
        }

        return true;
    }
}
