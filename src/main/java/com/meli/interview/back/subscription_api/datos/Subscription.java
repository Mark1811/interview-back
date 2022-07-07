package com.meli.interview.back.subscription_api.datos;

import javax.persistence.*;


@Entity
@Table(name = "suscripciones")
@Inheritance(strategy = InheritanceType.JOINED)
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String partner;

    @ManyToOne
    @JoinColumn(name = "fk_user", nullable = false, updatable = false)
    private User user;

    public float getPrice() {
        float price = 0;
        if (partner.equals("disney")) {
            price = 100;
        }

        if (partner.equals("netflix")) {
            price = 200;
        }

        if (partner.equals("spotify")) {
            price = 50;
        } else {
            price = 0;
        }

        return price;
    }
}
