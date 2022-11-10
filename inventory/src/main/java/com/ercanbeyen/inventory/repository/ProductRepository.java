package com.ercanbeyen.inventory.repository;

import com.ercanbeyen.inventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {

}
