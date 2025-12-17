package br.com.inatandev.infrastruture.mapper;

import br.com.inatandev.core.domain.Wallet;
import br.com.inatandev.infrastruture.entity.TransactionPinEntity;
import br.com.inatandev.infrastruture.entity.UserEntity;
import br.com.inatandev.infrastruture.entity.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {

    private TransactionPinMapper transactionPinMapper;

    private UserMapper userMapper;

    public WalletMapper(TransactionPinMapper transactionPinMapper, UserMapper userMapper) {
        this.transactionPinMapper = transactionPinMapper;
        this.userMapper = userMapper;
    }

    public WalletEntity toWalletEntity(Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPinEntity) {
        return new WalletEntity(
           wallet.getBalance(),
           userEntity,
           transactionPinEntity,
           wallet.getCreatedAt(),
           wallet.getUpdatedAt()
        );
    }

    public Wallet toWallet(WalletEntity walletEntity) throws Exception {
        if(walletEntity == null) {
            return null;
        }

        return new Wallet(
            walletEntity.getId(),
            transactionPinMapper.toTransactionPin(walletEntity.getTransactionPinEntity()),
            walletEntity.getBalance(),
            userMapper.toUser(walletEntity.getUserEntity()),
            walletEntity.getCreatedAt(),
            walletEntity.getUpdatedAt()
        );
    }
}
