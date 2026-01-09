package com.productManagement.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
public class ProductRequestDto {

    private Long id;

    @NotBlank(message = "Product name is required")
    private String productName;

    @NotBlank(message = "Product company is required")
    private String productCompany;

    @NotBlank(message = "Product detail is required")
    private String productDetail;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    private BigDecimal price;


}
