package com.ulstu.pikoff.subd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Timestamp creationDate;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String text;

    @ManyToOne
    private Ad ad;

    @ManyToOne
    private Client client;

    @Override
    public String toString() {
        return "Comment {" + "\n" +
                " id=" + id + ",\n" +
                " creationDate=" + creationDate + ",\n" +
                " text='" + text + '\'' + ",\n" +
                " client=" + client + ",\n" +
                "}\n";
    }
}