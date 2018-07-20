package com.johnbwhitejr.target.casestudy.controllers;

import com.johnbwhitejr.target.casestudy.beans.Product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") long id) {
        return new Product();
    }

    @PutMapping("/products/{id}")
    public Product updateProductPrice(@PathVariable("id") long id, @RequestBody double value,
                                      @RequestBody String currencyCode) {
        return new Product();
    }
}
