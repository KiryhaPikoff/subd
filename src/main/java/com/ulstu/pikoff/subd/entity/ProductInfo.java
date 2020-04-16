package com.ulstu.pikoff.subd.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ProductInfo {

    @Id
    @SequenceGenerator(name="product_info_seq", sequenceName="product_info_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="product_info_seq")
    private Long id;

    private String name;

    private boolean isNew;

    private String description;

    @OneToOne
    private Ad ad;
}