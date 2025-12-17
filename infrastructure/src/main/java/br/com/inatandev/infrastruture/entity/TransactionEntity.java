package br.com.inatandev.infrastruture.entity;

import br.com.inatandev.core.domain.enums.TransactionStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FromWallet")
    private WalletEntity fromWallet;

    @ManyToOne
    @JoinColumn(name = "ToWallet")
    private WalletEntity toWallet;

    @Column(name = "TransactionValue", nullable = false)
    private BigDecimal transactionValue;

    @Column(name = "Status")
    @Enumerated(EnumType.STRING)
    private TransactionStatusEnum status;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;
}
