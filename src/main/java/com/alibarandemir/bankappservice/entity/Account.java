package com.alibarandemir.bankappservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ACCOUNT")
@Data
public class Account extends BaseEntity {
    
    @Column(name = "account_number", nullable = false, unique = true)
    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Double balance = 0.0;
    
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
    
}
