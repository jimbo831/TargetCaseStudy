package com.johnbwhitejr.target.casestudy.services;

import com.johnbwhitejr.target.casestudy.beans.CurrentPrice;
import com.johnbwhitejr.target.casestudy.beans.Price;
import com.johnbwhitejr.target.casestudy.beans.ProductDTO;
import com.johnbwhitejr.target.casestudy.repositories.PriceRepository;
import com.johnbwhitejr.target.casestudy.utils.RedskyClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements  ProductService {

    private PriceRepository priceRepository;
    private RedskyClient redskyClient;

    @Autowired
    ProductServiceImpl(PriceRepository priceRepository, RedskyClient redskyClient) {
        this.priceRepository = priceRepository;
        this.redskyClient = redskyClient;
    }

    public ProductDTO getProduct(long id) {
        ProductDTO product = redskyClient.getProductById(id);
        Optional<Price> priceOptional = priceRepository.findById(id);
        if (priceOptional.isPresent()) {
            CurrentPrice current_price = priceOptional.get().getCurrent_price();
            product.setCurrent_price(current_price);
        }
        return product;
    }

    public ProductDTO updateProduct(long id, CurrentPrice current_price) {
        Price newPrice = new Price(id, current_price);
        priceRepository.save(newPrice);
        return getProduct(id);
    }
}
