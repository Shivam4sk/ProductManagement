package com.productManagement.exception;

public class ProductException extends RuntimeException{

    public ProductException(String message) {
        super(message);
    }

    public static ProductException getByIdNotFound(Long id) {
        return new ProductException("Product not found with id: " + id);
    }
}
