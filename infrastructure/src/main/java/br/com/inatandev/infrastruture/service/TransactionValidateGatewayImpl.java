package br.com.inatandev.infrastruture.service;

import br.com.inatandev.application.gateway.TransactionValidateGateway;
import br.com.inatandev.core.domain.Transaction;
import br.com.inatandev.infrastruture.client.ApiValidateService;
import br.com.inatandev.infrastruture.client.dto.response.ApiValidateResponse;
import org.springframework.stereotype.Service;

@Service
public class TransactionValidateGatewayImpl implements TransactionValidateGateway {

    private ApiValidateService apiValidateService;

    public TransactionValidateGatewayImpl(ApiValidateService apiValidateService) {
        this.apiValidateService = apiValidateService;
    }

    @Override
    public Boolean validate(Transaction transaction) {
        ApiValidateResponse response = apiValidateService.validate();
        if(response == null) {
            return false;
        }
        return response.success();
    }
}
