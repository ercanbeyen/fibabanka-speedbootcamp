package com.ercanbeyen.inventory.controller;

import com.ercanbeyen.inventory.dto.CategoryDto;
import com.ercanbeyen.inventory.dto.ProductDto;
import com.ercanbeyen.inventory.service.CategoryService;
import com.ercanbeyen.inventory.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public InventoryController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    /**
     *
     * @return all the categories
     */
    @GetMapping("/categories")
    public ResponseEntity<?> getCategories() {
        List<CategoryDto> categoryDtos = categoryService.getCategories();
        return ResponseEntity.ok(categoryDtos);
    }


    /**
     *
     * @param id This is the parameter represents category to filter the products
     * @return products filtered by a specific category
     */
    @GetMapping("/products/{categoryId}")
    public ResponseEntity<?> getProductsByCategory(@PathVariable("categoryId") int id) {
        List<ProductDto> productDtos = productService.getProducts(id);
        return ResponseEntity.ok(productDtos);
    }

    /**
     *
     * @param id This parameter is the id of the product
     * @return requested product
     */
    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") int id) {
        ProductDto productDto = productService.getProduct(id);
        return ResponseEntity.ok(productDto);
    }



}
