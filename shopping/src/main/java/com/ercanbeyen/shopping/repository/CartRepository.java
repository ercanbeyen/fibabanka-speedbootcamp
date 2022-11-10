package com.ercanbeyen.shopping.repository;

import com.ercanbeyen.shopping.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
