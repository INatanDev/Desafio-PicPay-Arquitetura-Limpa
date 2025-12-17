package br.com.inatandev.application.gateway;

import br.com.inatandev.core.domain.Transaction;

public interface UserNotificationGateway {

    Boolean notificate(Transaction transaction, String email);
}
