package com.ercanbeyen.shopping.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartDto {
    private int cartId;
    private String customerName;
    private double totalAmount;
    private boolean cartStatus;
    private List<CartProductDto> cartProducts;
}
