package com.ulstu.pikoff.subd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String surname;

    @OneToMany
    private Set<Ad> ads;

    @OneToMany
    private Set<Comment> comments;

    @Override
    public String toString() {
        return "Client {" + "\n" +
                " id=" + id + ",\n" +
                " name='" + name + '\'' + ",\n" +
                " surname='" + surname + '\'' + ",\n" +
                "}\n";
    }
}