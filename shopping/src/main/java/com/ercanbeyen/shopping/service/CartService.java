package com.ercanbeyen.shopping.service;

import com.ercanbeyen.shopping.dto.CartDto;

public interface CartService {
    int createCart();
    boolean checkout(int cartId);
    CartDto getCart(int cartId);
    void deleteProduct(int cartId, int productId);
}
