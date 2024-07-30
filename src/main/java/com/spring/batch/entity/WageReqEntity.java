package com.spring.batch.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "T_WAGE_REQ")
@Data
@ToString
public class WageReqEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "REQ_ID", nullable = false)
    private String requestId;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private int customerId;
}
