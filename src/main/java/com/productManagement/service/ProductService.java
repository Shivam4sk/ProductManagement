package com.productManagement.service;

import com.productManagement.dto.ProductRequestDto;
import com.productManagement.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    ProductResponseDto addProduct(ProductRequestDto productRequestDto);

    ProductResponseDto getProductById(Long id);

    List<ProductResponseDto> getAllProduct();

    ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto);

    void deleteProduct(Long id);
}
