package br.com.inatandev.infrastruture.service;

import br.com.inatandev.application.gateway.UserNotificationGateway;
import br.com.inatandev.core.domain.Transaction;
import org.springframework.stereotype.Service;

@Service
public class UserNotificationGatewayImpl implements UserNotificationGateway {


    @Override
    public Boolean notificate(Transaction transaction, String email) {
        //TODO: implementar
        return true;
    }
}
