package com.ercanbeyen.commerce.service.impl;

import com.ercanbeyen.commerce.service.ShoppingService;

import com.ercanbeyen.shopping.dto.CartDto;
import com.ercanbeyen.shopping.dto.CartProductDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShoppingServiceImpl implements ShoppingService {
    @Override
    public String createCart() {
        String url = "http://localhost:8082/api/shopping/cart/create";
        RestTemplate restTemplate = new RestTemplate();
        Integer result = restTemplate.getForObject(url, Integer.class);
        return "Cart with id " + result + " is created";
    }

    @Override
    public CartProductDto addProduct(CartProductDto cartProductDto) {
        String url = "http://localhost:8082/api/shopping/cart/add";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, cartProductDto, CartProductDto.class);
    }

    @Override
    public String deleteProduct(int cartId, int productId) {
        String url = "http://localhost:8082/api/shopping/cart/" + cartId + "/remove/" + productId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);
        return "Product with id " + productId + " in the cart with id " + cartId + " is removed";
    }

    @Override
    public String checkoutCart(int cartId) {
        String url = "http://localhost:8082/api/shopping/checkout/" + cartId;
        RestTemplate restTemplate = new RestTemplate();
        Boolean cartStatus = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                new HttpEntity<>(cartId),
                Boolean.class
        ).getBody();
        return "Checkout for cart with id " + cartId + " is completed. Cart Status : " + cartStatus;
    }

    @Override
    public CartDto getChart(int cartId) {
        String url = "http://localhost:8082/api/shopping/cart/find/" + cartId;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, CartDto.class);
    }
}
