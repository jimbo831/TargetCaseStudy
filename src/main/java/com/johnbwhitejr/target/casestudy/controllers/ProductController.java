package com.johnbwhitejr.target.casestudy.controllers;

import com.johnbwhitejr.target.casestudy.beans.CurrentPrice;
import com.johnbwhitejr.target.casestudy.beans.Price;
import com.johnbwhitejr.target.casestudy.beans.ProductDTO;
import com.johnbwhitejr.target.casestudy.services.ProductService;
import com.johnbwhitejr.target.casestudy.utils.RedskyClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private ProductService productService;
    private RedskyClient redskyClient;

    @Autowired
    public ProductController(ProductService productService, RedskyClient redskyClient) {
        this.productService = productService;
        this.redskyClient = redskyClient;
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProduct(@PathVariable("id") long id) {
        return productService.getProduct(id);
    }

    @PutMapping("/products/{id}")
    public ProductDTO updateProductPrice(@PathVariable("id") long id, @RequestBody double value,
                                         @RequestBody String currencyCode) {
        return new ProductDTO();
    }

    @PutMapping("testDb/{id}")
    public String addPrice(@PathVariable("id") long id, @RequestBody CurrentPrice current_price) {
        productService.addPriceToDb(id, current_price);
        return "Success";
    }

    @GetMapping("testDb/{id}")
    public Price getPrice(@PathVariable("id") long id) {
        return productService.getPriceByProductId(id);
    }

    @GetMapping("testApi/{id}")
    public ProductDTO getProductTest(@PathVariable("id") long id) {
        ProductDTO toReturn = redskyClient.getProductById(id);
        return toReturn;
    }
}
