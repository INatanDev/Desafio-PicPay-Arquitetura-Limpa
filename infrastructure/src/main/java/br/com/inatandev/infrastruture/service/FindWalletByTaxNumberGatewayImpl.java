package br.com.inatandev.infrastruture.service;

import br.com.inatandev.application.gateway.FindWalletByTaxNumberGateway;
import br.com.inatandev.core.domain.Wallet;
import br.com.inatandev.infrastruture.mapper.WalletMapper;
import br.com.inatandev.infrastruture.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class FindWalletByTaxNumberGatewayImpl implements FindWalletByTaxNumberGateway {

    private WalletEntityRepository walletEntityRepository;

    private WalletMapper  walletMapper;

    public FindWalletByTaxNumberGatewayImpl(WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    public Wallet findByTaxNumber(String taxNumber) throws Exception {
        return walletMapper.toWallet(walletEntityRepository.findByUserEntityTaxNumber(taxNumber));
    }
}
