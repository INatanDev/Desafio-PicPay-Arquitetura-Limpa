package br.com.inatandev.infrastruture.entity;

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
@Table(name = "Wallets")
public class WalletEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Balance",  nullable = false)
    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name = "UserId")
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "TransactionPinId")
    private TransactionPinEntity transactionPinEntity;

    @Column(name = "CreatedAt",  nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    public WalletEntity(BigDecimal balance, UserEntity userEntity, TransactionPinEntity transactionPinEntity, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.balance = balance;
        this.userEntity = userEntity;
        this.transactionPinEntity = transactionPinEntity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
