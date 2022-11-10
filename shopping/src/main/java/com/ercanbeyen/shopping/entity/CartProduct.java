package com.ercanbeyen.shopping.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * lineAmount: salesPrice * salesQuantity
 * totalAmount: total lineAmounts
 * */

@Entity
@Data
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartProductId;
    private int cartId;
    private int productId;
    private double salesQuantity;
    private double salesPrice;
    private double lineAmount;
}
