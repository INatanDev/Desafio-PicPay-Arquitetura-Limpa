package br.com.inatandev.infrastruture.mapper;

import br.com.inatandev.core.domain.TransactionPin;
import br.com.inatandev.infrastruture.entity.TransactionPinEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionPinMapper {

    public TransactionPinEntity toTransactionPinEntity(TransactionPin transactionPin){
        return new TransactionPinEntity(
            transactionPin.getPin(),
            transactionPin.getAttempt(),
            transactionPin.getBlocked(),
            transactionPin.getCreatedAt(),
            transactionPin.getUpdatedAt()
        );
    }

    public TransactionPin toTransactionPin(TransactionPinEntity transactionPinEntity) {
        return new TransactionPin(
             transactionPinEntity.getId(),
             transactionPinEntity.getPin(),
             transactionPinEntity.getAttempt(),
             transactionPinEntity.getBlocked(),
             transactionPinEntity.getCreatedAt(),
             transactionPinEntity.getUpdatedAt()
        );
    }
}
