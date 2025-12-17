package br.com.inatandev.application.usercaseimpl;

import br.com.inatandev.application.gateway.EmailAvailableGateway;
import br.com.inatandev.usecase.EmailAvailableUseCase;

public class EmailAvailableUseCaseImpl implements EmailAvailableUseCase {

    private EmailAvailableGateway emailAvailableGateway;

    public EmailAvailableUseCaseImpl(EmailAvailableGateway emailAvailableGateway) {
        this.emailAvailableGateway = emailAvailableGateway;
    }

    @Override
    public Boolean emailAvailableEmail(String email) {
        return emailAvailableGateway.emailAvailable(email);
    }
}
