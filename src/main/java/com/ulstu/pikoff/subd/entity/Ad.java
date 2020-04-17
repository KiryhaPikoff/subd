package com.ulstu.pikoff.subd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer rating;

    private Timestamp creationDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn(name = "product_info_id")
    private ProductInfo productInfo;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Category category;

    @OneToMany
    private Set<Comment> comments;

    @Override
    public String toString() {
        return "Ad {\n" +
                " id=" + id + ",\n" +
                " rating=" + rating + ",\n" +
                " creationDate=" + creationDate + ",\n" +
                " status=" + status + "\n" +
                " productInfo=" + productInfo + ",\n" +
                " client=" + client + ",\n" +
                " category=" + category + ",\n" +
                "}" + "\n";
    }
}