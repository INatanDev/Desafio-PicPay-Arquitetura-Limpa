package br.com.inatandev.core.domain;

import br.com.inatandev.core.domain.enums.TransactionStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {

    private Long id;
    private Wallet fromWallet;
    private Wallet toWallet;
    private BigDecimal value;
    private TransactionStatusEnum status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Transaction(Long id, Wallet fromWallet, Wallet toWallet, BigDecimal value, TransactionStatusEnum status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
        this.value = value;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Transaction(Wallet fromWallet, Wallet toWallet, BigDecimal value) {
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
        this.value = value;
        this.status = TransactionStatusEnum.CREATED;
        this.createdAt = LocalDateTime.now();
    }

    public Transaction(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Wallet getFromWallet() {
        return fromWallet;
    }

    public void setFromWallet(Wallet fromWallet) {
        this.fromWallet = fromWallet;
    }

    public Wallet getToWallet() {
        return toWallet;
    }

    public void setToWallet(Wallet toWallet) {
        this.toWallet = toWallet;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public TransactionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TransactionStatusEnum status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;
        return Objects.equals(getId(), that.getId()) && getFromWallet().equals(that.getFromWallet()) && getToWallet().equals(that.getToWallet()) && getValue().equals(that.getValue()) && getStatus() == that.getStatus() && getCreatedAt().equals(that.getCreatedAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getId());
        result = 31 * result + getFromWallet().hashCode();
        result = 31 * result + getToWallet().hashCode();
        result = 31 * result + getValue().hashCode();
        result = 31 * result + getStatus().hashCode();
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + Objects.hashCode(getUpdatedAt());
        return result;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", fromWallet=" + fromWallet +
                ", toWallet=" + toWallet +
                ", value=" + value +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
