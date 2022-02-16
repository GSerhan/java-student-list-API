package com.example.demo.offers.model;

public class Offers {
    private Long id;
    private String name;
    private Double cashback;
    private Boolean favorite;
    private String shopLink;

    public Offers(Long id, String name, Double cashback, Boolean favorite, String shopLink) {
        this.id = id;
        this.name = name;
        this.cashback = cashback;
        this.favorite = favorite;
        this.shopLink = shopLink;
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
