package com.johnbwhitejr.target.casestudy.beans;

// Item attribute from Redsky JSON response
public class Item {

    private long tcin;
    private ProductDescription product_description;

    public long getTcin() {
        return tcin;
    }

    public void setTcin(long tcin) {
        this.tcin = tcin;
    }

    public ProductDescription getProduct_description() {
        return product_description;
    }

    public void setProduct_description(ProductDescription product_description) {
        this.product_description = product_description;
    }
}
