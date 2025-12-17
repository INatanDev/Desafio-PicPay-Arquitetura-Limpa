package br.com.inatandev.usecase;

import br.com.inatandev.core.domain.Transaction;

public interface UserNotificationUseCase {

    Boolean notificate(Transaction transaction, String email);
}
