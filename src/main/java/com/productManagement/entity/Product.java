package com.productManagement.entity;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String productCompany;

    @Column(nullable = false)
    private String productDetail;

    @Column(nullable = false)
    private BigDecimal price;
}
