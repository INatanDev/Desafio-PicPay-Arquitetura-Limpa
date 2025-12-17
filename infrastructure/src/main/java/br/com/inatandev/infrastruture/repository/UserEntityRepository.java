package br.com.inatandev.infrastruture.repository;

import br.com.inatandev.infrastruture.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {

    Boolean existsByTaxNumber(String taxNumber);

    Boolean existsByEmail(String email);
}
