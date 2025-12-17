package br.com.inatandev.infrastruture.service;

import br.com.inatandev.application.gateway.TaxNumberAvailableGateway;
import br.com.inatandev.infrastruture.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import static br.com.inatandev.infrastruture.utils.Utilities.log;

@Service
public class TaxNumberAvailableUseCaseImpl implements TaxNumberAvailableGateway {

    private UserEntityRepository userEntityRepository;

    public TaxNumberAvailableUseCaseImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean taxNumberAvailable(String taxNumber) {
        log.info("Inicio da verificacao se o TaxNumber esta disponivel");
        return !userEntityRepository.existsByTaxNumber(taxNumber);
    }
}
