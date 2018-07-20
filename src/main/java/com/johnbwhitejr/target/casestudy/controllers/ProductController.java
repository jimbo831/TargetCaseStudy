package com.johnbwhitejr.target.casestudy.controllers;

import com.johnbwhitejr.target.casestudy.beans.Product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/products/{id}")
    public String getProduct(@PathVariable("id") long id) {
        return "get product for id: " + id;
    }
}
