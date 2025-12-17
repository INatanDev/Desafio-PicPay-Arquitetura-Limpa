package br.com.inatandev.infrastruture.service;

import br.com.inatandev.application.gateway.EmailAvailableGateway;
import br.com.inatandev.infrastruture.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import static br.com.inatandev.infrastruture.utils.Utilities.log;

@Service
public class EmailAvailableGatewayImpl implements EmailAvailableGateway {

    private UserEntityRepository userEntityRepository;

    public EmailAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean emailAvailable(String email) {
        log.info("Inicio da verificacao se o email esta disponivel");
        return !userEntityRepository.existsByEmail(email);
    }
}
