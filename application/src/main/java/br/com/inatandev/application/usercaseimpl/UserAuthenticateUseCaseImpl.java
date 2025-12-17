package br.com.inatandev.application.usercaseimpl;

import br.com.inatandev.application.gateway.UserAuthenticateGateway;
import br.com.inatandev.core.exception.AuthenticateException;
import br.com.inatandev.core.exception.enums.ErrorCodeEnum;
import br.com.inatandev.usecase.UserAuthenticateUseCase;

public class UserAuthenticateUseCaseImpl implements UserAuthenticateUseCase {

    private UserAuthenticateGateway userAuthenticateGateway;

    public UserAuthenticateUseCaseImpl(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }

    @Override
    public Boolean authenticate(String username, String password) throws AuthenticateException {

        if(!userAuthenticateGateway.authenticate(username, password)){
            throw new AuthenticateException(ErrorCodeEnum.ATH0001.getMessage(), ErrorCodeEnum.ATH0001.getCode());
        }

        return true;
    }
}
