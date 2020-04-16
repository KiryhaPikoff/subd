package com.ulstu.pikoff.subd.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @SequenceGenerator(name="category_seq", sequenceName="category_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="category_seq")
    private Integer id;

    private String name;

    @ManyToOne
    private Category parent;

    @OneToMany
    private Set<Ad> ads;
}