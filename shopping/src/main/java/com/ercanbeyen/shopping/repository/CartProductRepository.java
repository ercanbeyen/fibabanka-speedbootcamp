package com.ercanbeyen.shopping.repository;

import com.ercanbeyen.shopping.entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {

}
