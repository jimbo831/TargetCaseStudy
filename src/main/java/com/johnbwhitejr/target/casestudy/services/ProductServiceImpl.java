package com.johnbwhitejr.target.casestudy.services;

import com.johnbwhitejr.target.casestudy.beans.Price;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements  ProductService {

    public Price getPriceByProductId(long id) {
        return new Price();
    }
}
