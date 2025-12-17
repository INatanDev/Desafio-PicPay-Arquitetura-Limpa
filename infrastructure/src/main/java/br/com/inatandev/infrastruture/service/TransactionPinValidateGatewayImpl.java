package br.com.inatandev.infrastruture.service;

import br.com.inatandev.application.gateway.TransactionPinValidateGateway;
import br.com.inatandev.core.domain.TransactionPin;
import br.com.inatandev.infrastruture.repository.TransactionPinEntityRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TransactionPinValidateGatewayImpl implements TransactionPinValidateGateway {

    private TransactionPinEntityRepository transactionPinEntityRepository;

    public TransactionPinValidateGatewayImpl(TransactionPinEntityRepository transactionPinEntityRepository) {
        this.transactionPinEntityRepository = transactionPinEntityRepository;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin) {
        var transactionPinSaved = transactionPinEntityRepository.findById(transactionPin.getId());

        if(transactionPinSaved.isEmpty()) {
            return false;
        }

        if(!Objects.equals(transactionPinSaved.get().getPin(), transactionPin.getPin())) {
            return false;
        }
        return true;
    }
}
