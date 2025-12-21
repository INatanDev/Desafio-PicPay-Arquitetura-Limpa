package br.com.inatandev.infrastruture.service;

import br.com.inatandev.application.gateway.CreateTransactionGateway;
import br.com.inatandev.core.domain.Transaction;
import br.com.inatandev.infrastruture.mapper.TransactionMapper;
import br.com.inatandev.infrastruture.repository.TransactionEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionGatewayImpl implements CreateTransactionGateway {

    private TransactionEntityRepository transactionEntityRepository;

    private TransactionMapper transactionMapper;

    public CreateTransactionGatewayImpl(TransactionEntityRepository transactionEntityRepository, TransactionMapper transactionMapper) {
        this.transactionEntityRepository = transactionEntityRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public Transaction create(Transaction transaction){
        try {
            var transactionEntity = transactionMapper.createTransaction(transaction);
            return transactionMapper.toTransaction(transactionEntityRepository.save(transactionEntity));
        }catch (Exception ex){
            return null;
        }
    }
}
