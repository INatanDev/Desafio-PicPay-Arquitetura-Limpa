package br.com.inatandev.infrastruture.repository;

import br.com.inatandev.infrastruture.entity.TransactionPinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionPinEntityRepository extends JpaRepository<TransactionPinEntity, Long> {
}
