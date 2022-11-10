package com.ercanbeyen.inventory.service;

import com.ercanbeyen.inventory.dto.CategoryDto;
import com.ercanbeyen.inventory.entity.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getCategories();
    CategoryDto getCategory(int id);
}
