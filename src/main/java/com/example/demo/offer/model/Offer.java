package com.example.demo.offer.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Offer implements Serializable {
    @Id
    @SequenceGenerator(
            name="offer_sequence",
            sequenceName = "offer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "offer_sequence"
    )
    private Long id;
    private String name;
    private Double cashback;
    private Boolean favorite;
    private String shopLink;

    public Offer(Long id, String name, Double cashback, Boolean favorite, String shopLink) {
        this.id = id;
        this.name = name;
        this.cashback = cashback;
        this.favorite = favorite;
        this.shopLink = shopLink;
    }

    public Offer(String name, Double cashback, Boolean favorite, String shopLink) {
        this.name = name;
        this.cashback = cashback;
        this.favorite = favorite;
        this.shopLink = shopLink;
    }

    public Offer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCashback() {
        return cashback;
    }

    public void setCashback(Double cashback) {
        this.cashback = cashback;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public String getShopLink() {
        return shopLink;
    }

    public void setShopLink(String shopLink) {
        this.shopLink = shopLink;
    }
}
