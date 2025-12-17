package br.com.inatandev.application.gateway;

import br.com.inatandev.core.domain.User;
import br.com.inatandev.core.domain.Wallet;

public interface CreateUserGateway {

    Boolean create(User user, Wallet wallet);
}
