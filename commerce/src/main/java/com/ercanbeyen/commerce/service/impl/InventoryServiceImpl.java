package com.ercanbeyen.commerce.service.impl;

import com.ercanbeyen.commerce.service.InventoryService;
import com.ercanbeyen.inventory.dto.CategoryDto;
import com.ercanbeyen.inventory.dto.ProductDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Override
    public List<CategoryDto> getCategories() {
        String url = "http://localhost:8081/api/inventory/categories";
        RestTemplate restTemplate = new RestTemplate();

        /*
        List<CategoryDto> categoryDtos = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CategoryDto>>() {}
                ).getBody();
        */

        ResponseEntity<List<CategoryDto>> categoriesResponse = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CategoryDto>>() {}
        );

        List<CategoryDto> categoryDtos = categoriesResponse.getBody();

        return categoryDtos;
    }

    @Override
    public List<ProductDto> getProductsByCategory(int categoryId) {
        String url = "http://localhost:8081/api/inventory/products/" + categoryId;
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Integer> requestCategoryId = new HttpEntity<>(categoryId);
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestCategoryId,
                new ParameterizedTypeReference<List<ProductDto>>() {}
                ).getBody();
    }

    @Override
    public ProductDto getProduct(int productId) {
        String url = "http://localhost:8081/api/inventory/product/" + productId;
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Integer> requestProductId = new HttpEntity<>(productId);
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestProductId,
                ProductDto.class
        ).getBody();
    }
}