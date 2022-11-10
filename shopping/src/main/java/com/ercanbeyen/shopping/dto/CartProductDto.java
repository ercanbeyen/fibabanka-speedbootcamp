package com.ercanbeyen.shopping.dto;

import lombok.Data;

@Data
public class CartProductDto {
    private int cartProductId;
    private int cartId;
    private int productId;
    private double salesQuantity;
    private double salesPrice;
    private double lineAmount;
}
