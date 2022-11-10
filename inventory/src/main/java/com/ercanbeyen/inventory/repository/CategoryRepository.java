package com.ercanbeyen.inventory.repository;

import com.ercanbeyen.inventory.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
