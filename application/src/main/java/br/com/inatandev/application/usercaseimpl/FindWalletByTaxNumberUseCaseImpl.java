package br.com.inatandev.application.usercaseimpl;

import br.com.inatandev.application.gateway.FindWalletByTaxNumberGateway;
import br.com.inatandev.core.domain.Wallet;
import br.com.inatandev.core.exception.NotFoundException;
import br.com.inatandev.core.exception.enums.ErrorCodeEnum;
import br.com.inatandev.usecase.FindWalletByTaxNumberUseCase;

public class FindWalletByTaxNumberUseCaseImpl implements FindWalletByTaxNumberUseCase {

    private FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberUseCaseImpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        this.findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }

    @Override
    public Wallet findByTaxNumber(String taxNumber) throws Exception {
        var wallet = findWalletByTaxNumberGateway.findByTaxNumber(taxNumber);

        if(wallet == null){
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());
        }

        return wallet;
    }
}
