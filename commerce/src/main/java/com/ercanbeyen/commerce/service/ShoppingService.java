package com.ercanbeyen.commerce.service;

import com.ercanbeyen.shopping.dto.CartDto;
import com.ercanbeyen.shopping.dto.CartProductDto;

public interface ShoppingService {
    String createCart();
    CartProductDto addProduct(CartProductDto cartProductDto);
    String deleteProduct(int cartId, int productId);
    String checkoutCart(int cartId);
    CartDto getChart(int cartId);
}
