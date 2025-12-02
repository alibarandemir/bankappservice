package com.alibarandemir.bankappservice.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import com.alibarandemir.bankappservice.enums.TransactionType;

@Entity
@Table(name = "TRANSACTION")
@Data
public class Transaction extends BaseEntity {
    
    @ManyToOne
    @JoinColumn(name = "from_account_id")
    private Account fromAccount;
    
    @ManyToOne
    @JoinColumn(name = "to_account_id")
    private Account toAccount;
    
    @Column(nullable = false)
    private Double amount;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;
    
    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate = LocalDateTime.now();
    
    @Column(name = "description")
    private String description;
    
    
}
