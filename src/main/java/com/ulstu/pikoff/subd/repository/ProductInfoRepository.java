package com.ulstu.pikoff.subd.repository;

import com.ulstu.pikoff.subd.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Integer> {
}