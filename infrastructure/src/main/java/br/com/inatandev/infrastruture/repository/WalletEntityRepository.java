package br.com.inatandev.infrastruture.repository;

import br.com.inatandev.infrastruture.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long> {

    WalletEntity findByUserEntityTaxNumber(String taxNumber);
}
