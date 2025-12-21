package br.com.inatandev.infrastruture.service;

import br.com.inatandev.application.gateway.TransaferGateway;
import br.com.inatandev.core.domain.Transaction;
import br.com.inatandev.infrastruture.mapper.TransactionMapper;
import br.com.inatandev.infrastruture.mapper.WalletMapper;
import br.com.inatandev.infrastruture.repository.TransactionEntityRepository;
import br.com.inatandev.infrastruture.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransaferGatewayImpl implements TransaferGateway {

    private WalletEntityRepository walletEntityRepository;

    private WalletMapper walletMapper;

    private TransactionMapper transactionMapper;

    private TransactionEntityRepository transactionEntityRepository;

    public TransaferGatewayImpl(WalletEntityRepository walletEntityRepository, TransactionEntityRepository transactionEntityRepository) {
        this.walletEntityRepository = walletEntityRepository;
        this.transactionEntityRepository = transactionEntityRepository;
    }

    @Override
    @Transactional
    public Boolean Transfer(Transaction transaction) {
        try {
            walletEntityRepository.save(walletMapper.toWalletEntity(transaction.getFromWallet()));
            walletEntityRepository.save(walletMapper.toWalletEntity(transaction.getToWallet()));

            transactionEntityRepository.save(transactionMapper.concludeTransaction(transaction));
            return true;
        }catch (Exception e){
            transactionEntityRepository.save(transactionMapper.cancelTransaction(transaction));
            return false;
        }
    }
}
