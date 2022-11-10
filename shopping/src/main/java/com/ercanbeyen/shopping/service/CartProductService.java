package com.ercanbeyen.shopping.service;

import com.ercanbeyen.shopping.dto.CartProductDto;

import java.util.List;

public interface CartProductService {
    CartProductDto addProduct(CartProductDto cartProductDto);
    void deleteProduct(int productId);
    List<CartProductDto> getCartProducts(int cartId);
}
