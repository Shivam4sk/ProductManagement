package com.productManagement.controller;

import com.productManagement.dto.ProductRequestDto;
import com.productManagement.dto.ProductResponseDto;
import com.productManagement.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
@Tag(name = "Product API", description = "Product CRUD Operations")
public class ProcuctController {

    private final ProductService productService;

    @Operation(summary = "Delete Product")
    @PostMapping("/saveProduct")
    public ProductResponseDto saveProduct (@Valid @RequestBody ProductRequestDto productRequestDto){
        return productService.addProduct(productRequestDto);
    }

    @Operation(summary = "Get Product By  Product Id")
    @GetMapping("getById")
    public ProductResponseDto getProductById(@RequestParam Long id){
        return productService.getProductById(id);
    }

    @Operation(summary = "Get All Product")
    @GetMapping("/getAll")
    public List<ProductResponseDto> getAllProduct(){
        return productService.getAllProduct();
    }

    @Operation(summary = "Update Product")
    @PutMapping("/updateProduct")
    public ProductResponseDto updateProduct(@RequestParam Long id, @RequestBody ProductRequestDto productRequestDto){
        return productService.updateProduct(id,productRequestDto);
    }

    @Operation(summary = "Delete Product")
    @DeleteMapping("/deleteById")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
    }


}
