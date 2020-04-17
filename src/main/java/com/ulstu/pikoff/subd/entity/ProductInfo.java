package com.ulstu.pikoff.subd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private boolean isNew;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String description;

    @OneToOne(mappedBy = "productInfo")
    private Ad ad;

    @Override
    public String toString() {
        return "ProductInfo {" + "\n" +
                " id=" + id + ",\n" +
                " name='" + name + '\'' + ",\n" +
                " isNew=" + isNew + ",\n" +
                " description='" + description + '\'' + ",\n" +
                "}\n";
    }
}