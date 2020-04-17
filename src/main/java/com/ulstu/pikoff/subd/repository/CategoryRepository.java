package com.ulstu.pikoff.subd.repository;

import com.ulstu.pikoff.subd.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}