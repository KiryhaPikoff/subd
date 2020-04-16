package com.ulstu.pikoff.subd.repository;

import com.ulstu.pikoff.subd.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}