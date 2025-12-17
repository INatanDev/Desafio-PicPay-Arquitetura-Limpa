package br.com.inatandev.usecase;

import br.com.inatandev.core.exception.AuthenticateException;

public interface UserAuthenticateUseCase {

    Boolean authenticate(String username, String password) throws AuthenticateException;
}
