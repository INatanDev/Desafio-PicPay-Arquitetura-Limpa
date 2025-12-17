package br.com.inatandev.usecase;

import br.com.inatandev.core.domain.User;
import br.com.inatandev.core.exception.EmailException;
import br.com.inatandev.core.exception.InternalServerErrorException;
import br.com.inatandev.core.exception.TaxNumberException;
import br.com.inatandev.core.exception.TransactionPinException;

public interface CreateUserUseCase {

    void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException;
}
