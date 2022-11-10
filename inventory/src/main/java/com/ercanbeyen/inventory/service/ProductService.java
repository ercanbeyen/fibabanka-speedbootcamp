package com.ercanbeyen.inventory.service;

import com.ercanbeyen.inventory.dto.ProductDto;
import com.ercanbeyen.inventory.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProducts(int categoryId);
    ProductDto getProduct(int id);
}
