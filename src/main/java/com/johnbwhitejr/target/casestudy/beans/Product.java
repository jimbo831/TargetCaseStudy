package com.johnbwhitejr.target.casestudy.beans;

public class Product {

    private long id;
    private String name;
    private Price currentPrice;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price getCurrentPrice() {
        return this.currentPrice;
    }

    public void setCurrentPrice(Price currentPrice) {
        this.currentPrice = currentPrice;
    }
}
