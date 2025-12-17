package br.com.inatandev.application.usercaseimpl;

import br.com.inatandev.application.gateway.CreateUserGateway;
import br.com.inatandev.core.domain.TransactionPin;
import br.com.inatandev.core.domain.User;
import br.com.inatandev.core.domain.Wallet;
import br.com.inatandev.core.exception.EmailException;
import br.com.inatandev.core.exception.InternalServerErrorException;
import br.com.inatandev.core.exception.TaxNumberException;
import br.com.inatandev.core.exception.TransactionPinException;
import br.com.inatandev.core.exception.enums.ErrorCodeEnum;
import br.com.inatandev.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private TaxNumberAvailableUseCase taxNumberAvailableUseCase;

    private EmailAvailableUseCase emailAvailableUseCase;

    private CreateUserGateway  createUserGateway;

    public CreateUserUseCaseImpl(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway) {
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException {
        if (!taxNumberAvailableUseCase.taxNumberAvailable(user.getTaxNumber().getValue())){
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        if (!emailAvailableUseCase.emailAvailableEmail(user.getEmail())){
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        if(!createUserGateway.create(user, new Wallet( new TransactionPin(pin), BigDecimal.ZERO, user))){
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }

    }

}
