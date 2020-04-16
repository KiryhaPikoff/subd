package com.ulstu.pikoff.subd.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CategoryNameWithMaxRating {

    private String categoryName;

    private Integer rating;
}