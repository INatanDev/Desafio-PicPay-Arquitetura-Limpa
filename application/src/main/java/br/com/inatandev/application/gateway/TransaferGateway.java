package br.com.inatandev.application.gateway;

import br.com.inatandev.core.domain.Transaction;

public interface TransaferGateway {

    Boolean Transfer(Transaction transaction);
}
