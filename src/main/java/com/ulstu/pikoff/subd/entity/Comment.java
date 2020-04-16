package com.ulstu.pikoff.subd.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @SequenceGenerator(name="comment_seq", sequenceName="comment_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="comment_seq")
    private Integer id;

    private Timestamp creationDate;

    private String text;

    @ManyToOne
    private Ad ad;

    @ManyToOne
    private Client client;
}