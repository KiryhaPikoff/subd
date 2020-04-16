package com.ulstu.pikoff.subd.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Getter
@Setter
public class Ad {

    @Id
    @SequenceGenerator(name="ad_seq", sequenceName="ad_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="ad_seq")
    private Integer id;

    private Integer rating;

    private Timestamp creationDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    private ProductInfo productInfo;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Category category;

    @OneToMany
    private Set<Comment> comments;
}