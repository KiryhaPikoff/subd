package com.ulstu.pikoff.subd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    private Category parent;

    @OneToMany
    @JoinColumn(name = "category_id")
    private Set<Ad> ads;

    @Override
    public String toString() {
        return "Category {\n" +
                " id=" + id + ",\n" +
                " name='" + name + '\'' + ",\n" +
                " parent=" + (Objects.isNull(parent) ? "нет" : parent.name) + ",\n" +
                "}" + "\n";
    }
}