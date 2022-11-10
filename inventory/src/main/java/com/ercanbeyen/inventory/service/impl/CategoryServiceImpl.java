package com.ercanbeyen.inventory.service.impl;

import com.ercanbeyen.inventory.dto.CategoryDto;
import com.ercanbeyen.inventory.dto.ProductDto;
import com.ercanbeyen.inventory.entity.Category;
import com.ercanbeyen.inventory.repository.CategoryRepository;
import com.ercanbeyen.inventory.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getCategories() {
        log.info("We are in getProducts method");

        List<CategoryDto> categoryDtos = new ArrayList<>();

        categoryRepository.findAll().forEach(
                category -> {
                    /*
                    CategoryDto categoryDto = CategoryDto
                            .builder()
                            .categoryId(category.getCategoryId())
                            .categoryName(category.getCategoryName())
                            .build();

                     */

                    CategoryDto categoryDto = new CategoryDto();
                    categoryDto.setCategoryId(categoryDto.getCategoryId());
                    categoryDto.setCategoryName(category.getCategoryName());

                    categoryDtos.add(categoryDto);
                });

        return categoryDtos;
    }

    @Override
    public CategoryDto getCategory(int id) {
        log.info("We are in getCategory method");

        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new NullPointerException("Category with id " + id + " is not found")
        );

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(categoryDto.getCategoryId());
        categoryDto.setCategoryName(category.getCategoryName());

        return categoryDto;

        /*return CategoryDto
                .builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .build();
         */
    }
}
