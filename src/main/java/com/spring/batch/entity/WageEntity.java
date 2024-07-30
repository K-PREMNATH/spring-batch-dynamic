package com.spring.batch.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "T_WAGE")
@Data
public class WageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pd_mth", nullable = false)
    private int paidMonth;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private int customerId;

    @Column(name = "wage_amount", nullable = false)
    private double wageAmount;
}
