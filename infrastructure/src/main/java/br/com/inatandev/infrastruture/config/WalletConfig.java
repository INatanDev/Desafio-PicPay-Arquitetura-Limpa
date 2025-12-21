package br.com.inatandev.infrastruture.config;

import br.com.inatandev.application.gateway.*;
import br.com.inatandev.application.usercaseimpl.*;
import br.com.inatandev.core.domain.TransactionPin;
import br.com.inatandev.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WalletConfig {

    @Bean
    public FindWalletByTaxNumberUseCase  findWalletByTaxNumberUseCase(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        return new FindWalletByTaxNumberUseCaseImpl(findWalletByTaxNumberGateway);
    }

    @Bean
    public ConsultBalanceUseCase consultBalanceUseCase(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase) {
        return new ConsultBalanceUseCaseImpl(findWalletByTaxNumberUseCase);
    }

    @Bean
    public TransactionValidateUseCase transactionValidateUseCase(TransactionValidateGateway transactionValidateGateway){
        return new TransactionValidateUseCaseImpl(transactionValidateGateway);
    }

    @Bean
    public CreateTransactionUseCase createTransactionUseCase(CreateTransactionGateway createTransactionGateway){
        return new CreateTransactionUseCaseImpl(createTransactionGateway);
    }

    @Bean
    public UserNotificationUseCase userNotificationUseCase(UserNotificationGateway userNotificationGateway){
        return new UserNotificationUseCaseImpl(userNotificationGateway);
    }

    @Bean
    public UpdateTransactionPinUseCase updateTransactionPinUseCase(){
        return new UpdateTransactionPinUseCase() {
            @Override
            public TransactionPin updateTransactionPin(TransactionPin transactionPin) {
                return null;
            }
        };
    }

    @Bean
    public TransactionPinValidateUseCase transactionPinValidateUseCase(TransactionPinValidateGateway transactionPinValidateGateway,UpdateTransactionPinUseCase updateTransactionPinUseCase){
        return new TransactionPinValidateUseCaseImpl(transactionPinValidateGateway,updateTransactionPinUseCase);
    }

    @Bean
    public TransferUseCase transferUseCase(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, CreateTransactionUseCase createTransactionUseCase, TransaferGateway transaferGateway, UserNotificationUseCase userNotificationUseCase, TransactionPinValidateUseCase transactionPinValidateUseCase) {
        return new TransferUseCaseImpl(findWalletByTaxNumberUseCase, transactionValidateUseCase, createTransactionUseCase, transaferGateway, userNotificationUseCase, transactionPinValidateUseCase);
    }
}
