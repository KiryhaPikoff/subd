package com.ulstu.pikoff.subd.repository;

import com.ulstu.pikoff.subd.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Integer> {

    @Query("SELECT new com.ulstu.pikoff.subd.repository.CategoryNameWithCount(category.name, COUNT(a)) FROM Ad a " +
            " JOIN Category category ON a.category = category " +
            " GROUP BY category.name" +
            " ORDER BY COUNT(a) DESC ")
    List<CategoryNameWithCount> getNameCategoryCount();

    @Query("SELECT new com.ulstu.pikoff.subd.repository.CategoryNameWithMaxRating(category.name, MAX(ad.rating)) FROM Ad ad " +
            " JOIN Category category ON ad.category = category " +
            " WHERE ad.creationDate BETWEEN :fromDate AND :toDate" +
            " GROUP BY category.name" +
            " ORDER BY MAX(ad.rating) DESC ")
    List<CategoryNameWithMaxRating> getCategoryRating(Timestamp fromDate, Timestamp toDate);
}