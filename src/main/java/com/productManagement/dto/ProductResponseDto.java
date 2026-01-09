package com.productManagement.dto;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
@Data
public class ProductResponseDto {

    private Long id;
    private String productName;
    private String productCompany;
    private String productDetail;
    private BigDecimal price;
}
