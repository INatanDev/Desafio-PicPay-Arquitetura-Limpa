package br.com.inatandev.infrastruture.repository;

import br.com.inatandev.infrastruture.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionEntityRepository extends JpaRepository<TransactionEntity, Long> {
}
