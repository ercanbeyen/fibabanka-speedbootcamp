package com.ercanbeyen.commerce.service;

import com.ercanbeyen.inventory.dto.CategoryDto;
import com.ercanbeyen.inventory.dto.ProductDto;

import java.util.List;

public interface InventoryService {
    List<CategoryDto> getCategories();
    List<ProductDto> getProductsByCategory(int categoryId);
    ProductDto getProduct(int productId);
}
