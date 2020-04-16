package com.ulstu.pikoff.subd.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Client {

    @Id
    @SequenceGenerator(name="client_seq", sequenceName="client_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="client_seq")
    private Integer id;

    private String name;

    private String address;

    private String surname;

    @OneToMany
    private Set<Ad> ads;

    @OneToMany
    private Set<Comment> comments;
}