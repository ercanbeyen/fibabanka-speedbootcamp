package com.ercanbeyen.inventory.service.impl;

import com.ercanbeyen.inventory.repository.ProductRepository;
import com.ercanbeyen.inventory.dto.ProductDto;
import com.ercanbeyen.inventory.entity.Product;
import com.ercanbeyen.inventory.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> getProducts(int categoryId) {
        log.info("We are in getProducts method");

        List<ProductDto> productDtos = new ArrayList<>();

        List<Product> products = productRepository
                .findAll()
                .stream()
                .filter(product -> product.getCategoryId() == categoryId)
                .toList();

        products.forEach(
                product -> {
                    ProductDto productDto = new ProductDto();
                    productDto.setProductId(product.getProductId());
                    productDto.setProductName(product.getProductName());
                    productDto.setSalesPrice(product.getSalesPrice());
                    productDto.setCategoryId(product.getCategoryId());

                    productDtos.add(productDto);
                });

        return productDtos;
    }

    @Override
    public ProductDto getProduct(int id) {
        log.info("We are in getProduct method");


        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("Product with id " + id + " is not found")
        );

        /*
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {

        }
         */

        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getProductName());
        productDto.setSalesPrice(product.getSalesPrice());
        productDto.setCategoryId(product.getCategoryId());

        return productDto;
    }
}
