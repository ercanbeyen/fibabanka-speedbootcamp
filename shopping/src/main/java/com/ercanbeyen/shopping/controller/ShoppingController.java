package com.ercanbeyen.shopping.controller;

import com.ercanbeyen.shopping.dto.CartDto;
import com.ercanbeyen.shopping.dto.CartProductDto;
import com.ercanbeyen.shopping.service.CartProductService;
import com.ercanbeyen.shopping.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shopping")
public class ShoppingController {
    private final CartService cartService;
    private final CartProductService cartProductService;

    public ShoppingController(CartService cartService, CartProductService cartProductService) {
        this.cartService = cartService;
        this.cartProductService = cartProductService;
    }

    /**
     *
     * @return CartDto object
     */
    @GetMapping("/cart/create")
    public ResponseEntity<?> createCart() {
        int createdId = cartService.createCart();
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    /**
     *
     * @param cartProductDto This is added to the chart
     * @return added CartProductDto object
     */
    @PostMapping("/cart/add")
    public ResponseEntity<?> addProduct(@RequestBody CartProductDto cartProductDto) {
        CartProductDto addedProduct = cartProductService.addProduct(cartProductDto);
        return new ResponseEntity<>(addedProduct, HttpStatus.OK);
    }

    /**
     *
     * @param cartId This is used to find the category
     * @param productId This is used to find the product
     * @return Nothing
     */
    @DeleteMapping("/cart/{cartId}/remove/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("cartId") int cartId, @PathVariable("productId") int productId) {
        cartService.deleteProduct(cartId, productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     *
     * @param cartId This is used to find the cart
     * @return Updated status of the specific cart
     */
    @PutMapping("/checkout/{cartId}")
    public ResponseEntity<?> checkoutCart(@PathVariable("cartId") int cartId) {
        boolean cartStatus = cartService.checkout(cartId);
        return new ResponseEntity<>(cartStatus, HttpStatus.OK);
    }

    /**
     *
     * @param cartId This is used to find the cart
     * @return The specific cart
     */
    @GetMapping("/cart/find/{cartId}")
    public ResponseEntity<?> getChart(@PathVariable("cartId") int cartId) {
        CartDto cartDto = cartService.getCart(cartId);
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }
}
