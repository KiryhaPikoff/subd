package com.ulstu.pikoff.subd.repository;

import com.ulstu.pikoff.subd.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, Integer> {
}