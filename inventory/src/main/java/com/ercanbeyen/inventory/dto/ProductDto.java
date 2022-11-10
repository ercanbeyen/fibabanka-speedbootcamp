package com.ercanbeyen.inventory.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ProductDto {
    private int productId;
    private String productName;
    private double salesPrice;
    private int categoryId;
}
