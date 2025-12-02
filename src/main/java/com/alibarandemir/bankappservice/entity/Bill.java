package com.alibarandemir.bankappservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import com.alibarandemir.bankappservice.enums.BillType;
@Entity
@Table(name = "BILL")
@Data
public class Bill extends BaseEntity {
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BillType billType;
    
    @Column(nullable = false)
    private String subscriberNumber; // Abone numarası
    
    @Column(nullable = false)
    private Double amount;
    
    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;
    
    @Column(name = "is_paid", nullable = false)
    private Boolean isPaid = false;
    
    @Column(name = "payment_date")
    private LocalDate paymentDate;
    
    
}

