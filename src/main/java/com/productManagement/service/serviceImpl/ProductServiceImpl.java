package com.productManagement.service.serviceImpl;

import com.productManagement.dto.ProductRequestDto;
import com.productManagement.dto.ProductResponseDto;
import com.productManagement.entity.Product;
import com.productManagement.exception.ProductException;
import com.productManagement.repository.ProductRepository;
import com.productManagement.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {
        Product product = mapToEntity(productRequestDto);
        return mapToDto(productRepository.save(product));
    }


    @Override
    public ProductResponseDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> ProductException.getByIdNotFound(id));

         return mapToDto(product);
    }

    @Override
    public List<ProductResponseDto> getAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> ProductException.getByIdNotFound(id));

        existingProduct.setProductName(productRequestDto.getProductName());
        existingProduct.setProductCompany(productRequestDto.getProductCompany());
        existingProduct.setProductDetail(productRequestDto.getProductDetail());
        existingProduct.setPrice(productRequestDto.getPrice());

        Product updatedProduct = productRepository.save(existingProduct);

        return mapToDto(updatedProduct);
    }


    @Override
    public void deleteProduct(Long id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(()->ProductException.getByIdNotFound(id));
        productRepository.delete(existingProduct);
    }


    private Product mapToEntity(ProductRequestDto dto) {
        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setProductCompany(dto.getProductCompany());
        product.setProductDetail(dto.getProductDetail());
        product.setPrice(dto.getPrice());
        return product;
    }

    private ProductResponseDto mapToDto(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setProductName(product.getProductName());
        dto.setProductCompany(product.getProductCompany());
        dto.setProductDetail(product.getProductDetail());
        dto.setPrice(product.getPrice());
        return dto;
    }

}
