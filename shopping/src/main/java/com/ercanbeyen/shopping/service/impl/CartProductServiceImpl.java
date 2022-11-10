package com.ercanbeyen.shopping.service.impl;

import com.ercanbeyen.shopping.dto.CartProductDto;

import com.ercanbeyen.shopping.entity.CartProduct;
import com.ercanbeyen.shopping.repository.CartProductRepository;
import com.ercanbeyen.shopping.service.CartProductService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class CartProductServiceImpl implements CartProductService {
    private final CartProductRepository cartProductRepository;

    public CartProductServiceImpl(CartProductRepository cartProductRepository) {
        this.cartProductRepository = cartProductRepository;
    }

    @Override
    public CartProductDto addProduct(CartProductDto cartProductDto) {
        CartProduct new_cartProduct = new CartProduct();
        new_cartProduct.setProductId(cartProductDto.getProductId());
        new_cartProduct.setCartId(cartProductDto.getCartId());
        new_cartProduct.setLineAmount(cartProductDto.getLineAmount());
        new_cartProduct.setSalesPrice(cartProductDto.getSalesPrice());
        new_cartProduct.setSalesQuantity(cartProductDto.getSalesQuantity());


      CartProduct saved_cartProduct = cartProductRepository.save(new_cartProduct);


        CartProductDto result = new CartProductDto();
        result.setCartProductId(saved_cartProduct.getCartProductId());
        result.setCartId(saved_cartProduct.getCartId());
        result.setLineAmount(saved_cartProduct.getLineAmount());
        result.setSalesPrice(saved_cartProduct.getSalesPrice());
        result.setSalesQuantity(saved_cartProduct.getSalesQuantity());

        return result;
    }

    @Override
    public void deleteProduct(int productId) {
        cartProductRepository.deleteById(productId);
    }

    @Override
    public List<CartProductDto> getCartProducts(int cartId) {
        List<CartProduct> cartProducts = cartProductRepository
                .findAll()
                .stream()
                .filter(cartProduct -> cartProduct.getCartId() == cartId)
                .toList();

        List<CartProductDto> cartProductDtos = new ArrayList<>();

        cartProducts.forEach(
                cartProduct -> {
                    CartProductDto cartProductDto = new CartProductDto();
                    cartProductDto.setCartProductId(cartProduct.getCartProductId());
                    cartProductDto.setCartId(cartProduct.getCartId());
                    cartProductDto.setLineAmount(cartProduct.getLineAmount());
                    cartProductDto.setSalesPrice(cartProduct.getSalesPrice());
                    cartProductDto.setSalesQuantity(cartProduct.getSalesQuantity());
                    cartProductDtos.add(cartProductDto);
                }
        );

        return cartProductDtos;
    }

}
