package com.johnbwhitejr.target.casestudy.beans;

// ProductDTO representation for this application endpoint
public class ProductDTO {

    private long id;
    private String name;
    private CurrentPrice current_price;

    public ProductDTO() {

    }

    public ProductDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public CurrentPrice getCurrent_price() {
        return this.current_price;
    }

    public void setCurrent_price(CurrentPrice current_price) {
        this.current_price = current_price;
    }
}
