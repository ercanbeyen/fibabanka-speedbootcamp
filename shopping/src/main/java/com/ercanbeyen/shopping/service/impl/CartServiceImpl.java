package com.ercanbeyen.shopping.service.impl;

import com.ercanbeyen.shopping.dto.CartDto;
import com.ercanbeyen.shopping.dto.CartProductDto;
import com.ercanbeyen.shopping.entity.Cart;
import com.ercanbeyen.shopping.entity.CartProduct;
import com.ercanbeyen.shopping.repository.CartRepository;
import com.ercanbeyen.shopping.service.CartProductService;
import com.ercanbeyen.shopping.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    private final CartProductService cartProductService;

    public CartServiceImpl(CartRepository cartRepository, CartProductService cartProductService) {
        this.cartRepository = cartRepository;
        this.cartProductService = cartProductService;
    }

    @Override
    public int createCart() {
        /*
        Cart cart = Cart
                .builder()
                .customerName("Demo_Customer")
                .totalAmount(0)
                .cartStatus(false)
                .build();

         */

        Cart newCart = new Cart();
        newCart.setCustomerName("Demo_customer");
        newCart.setTotalAmount(0);
        newCart.setCartStatus(false);

        Cart savedCart = cartRepository.save(newCart);
        return savedCart.getCartId();
    }

    @Override
    public boolean checkout(int cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(
                () -> new NullPointerException("Cart with id " + cartId + " is not found")
        );

        boolean newStatus = true;
        cart.setCartStatus(newStatus);

        cartRepository.save(cart);

        return newStatus;
    }

    @Override
    public CartDto getCart(int cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(
                () -> new NullPointerException("Cart with id " + cartId + " is not found")
        );

        List<CartProductDto> cartProductDtos = cartProductService.getCartProducts(cartId);

        /*return CartDto
                .builder()
                .cartProducts(cartProductDtos)
                .cartStatus(cart.isCartStatus())
                .cartId(cart.getCartId())
                .customerName(cart.getCustomerName())
                .totalAmount(cart.getTotalAmount())
                .build();

         */

        CartDto cartDto = new CartDto();
        cartDto.setCartProducts(cartProductDtos);
        cartDto.setCartStatus(cart.isCartStatus());
        cartDto.setCartId(cart.getCartId());
        cartDto.setCustomerName(cart.getCustomerName());
        cartDto.setTotalAmount(cart.getTotalAmount());

        return cartDto;
    }

    @Override
    public void deleteProduct(int cartId, int productId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(
                () -> new NullPointerException("Cart with id " + cartId + " is not found")
        );

        cartProductService.deleteProduct(productId);
    }


}
