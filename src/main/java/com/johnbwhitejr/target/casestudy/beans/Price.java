package com.johnbwhitejr.target.casestudy.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Price document in Mongoose DB
@Document(collection = "prices")
public class Price {

    @Id
    private long id;
    private CurrentPrice current_price;

    public Price () {

    }

    public Price (long id, CurrentPrice current_price) {
        this.id = id;
        this.current_price = current_price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CurrentPrice getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(CurrentPrice current_price) {
        this.current_price = current_price;
    }
}
