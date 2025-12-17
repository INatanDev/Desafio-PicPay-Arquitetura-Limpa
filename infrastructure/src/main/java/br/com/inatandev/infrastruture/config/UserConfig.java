package br.com.inatandev.infrastruture.config;

import br.com.inatandev.application.gateway.CreateUserGateway;
import br.com.inatandev.application.gateway.EmailAvailableGateway;
import br.com.inatandev.application.gateway.TaxNumberAvailableGateway;
import br.com.inatandev.application.usercaseimpl.CreateUserUseCaseImpl;
import br.com.inatandev.application.usercaseimpl.EmailAvailableUseCaseImpl;
import br.com.inatandev.application.usercaseimpl.TaxNumberAvailableUseCaseImpl;
import br.com.inatandev.usecase.CreateUserUseCase;
import br.com.inatandev.usecase.EmailAvailableUseCase;
import br.com.inatandev.usecase.TaxNumberAvailableUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public TaxNumberAvailableUseCase taxNumberAvailableUseCase(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        return new TaxNumberAvailableUseCaseImpl(taxNumberAvailableGateway);
    }

    @Bean
    public EmailAvailableUseCase emailAvailableUseCase(EmailAvailableGateway emailAvailableGateway){
        return new EmailAvailableUseCaseImpl(emailAvailableGateway);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway) {
        return new CreateUserUseCaseImpl(taxNumberAvailableUseCase, emailAvailableUseCase, createUserGateway);
    }
}
