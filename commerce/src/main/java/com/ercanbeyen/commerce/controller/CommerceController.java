package com.ercanbeyen.commerce.controller;

import com.ercanbeyen.commerce.service.InventoryService;
import com.ercanbeyen.commerce.service.ShoppingService;
import com.ercanbeyen.inventory.dto.CategoryDto;
import com.ercanbeyen.inventory.dto.ProductDto;

import com.ercanbeyen.shopping.dto.CartDto;
import com.ercanbeyen.shopping.dto.CartProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commerce")
public class CommerceController {
    private final InventoryService inventoryService;
    private final ShoppingService shoppingService;

    public CommerceController(InventoryService inventoryService, ShoppingService shoppingService) {
        this.inventoryService = inventoryService;
        this.shoppingService = shoppingService;
    }

    @GetMapping("/inventory/categories")
    public ResponseEntity<List<CategoryDto>> getCategories() {
        List<CategoryDto> categoryDtos = inventoryService.getCategories();
        return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
    }

    @GetMapping("/inventory/products/{categoryId}")
    public ResponseEntity<?> getProductsByCategoryId(@PathVariable("categoryId") int categoryId) {
        List<ProductDto> productDtos = inventoryService.getProductsByCategory(categoryId);
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    @GetMapping("/inventory/product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") int productId) {
        ProductDto productDto = inventoryService.getProduct(productId);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping("/shopping/cart/create")
    public ResponseEntity<?> createCart() {
        String cartId_message = shoppingService.createCart();
        return new ResponseEntity<>(cartId_message, HttpStatus.CREATED);
    }

    @PostMapping("/shopping/cart/add")
    public ResponseEntity<?> addProduct(@RequestBody CartProductDto cartProductDto) {
        CartProductDto addedCartProductDto = shoppingService.addProduct(cartProductDto);
        return new ResponseEntity<>(cartProductDto, HttpStatus.OK);
    }

    @DeleteMapping("/shopping/cart/{cartId}/remove/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("cartId") int cartId, @PathVariable("productId") int productId) {
        String deleteProduct_message = shoppingService.deleteProduct(cartId, productId);
        return new ResponseEntity<>(deleteProduct_message, HttpStatus.OK);
    }

    @PutMapping("/shopping/checkout/{cartId}")
    public ResponseEntity<?> checkoutChart(@PathVariable("cartId") int cartId) {
        String checkout_message = shoppingService.checkoutCart(cartId);
        return new ResponseEntity<>(checkout_message, HttpStatus.OK);
    }

    @GetMapping("/shopping/cart/find/{cartId}")
    public ResponseEntity<?> getChart(@PathVariable("cartId") int cartId) {
        CartDto cartDto = shoppingService.getChart(cartId);
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }
}
