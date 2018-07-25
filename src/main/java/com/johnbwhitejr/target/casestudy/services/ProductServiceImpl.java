package com.johnbwhitejr.target.casestudy.services;

import com.johnbwhitejr.target.casestudy.beans.CurrentPrice;
import com.johnbwhitejr.target.casestudy.beans.Price;
import com.johnbwhitejr.target.casestudy.beans.Product;
import com.johnbwhitejr.target.casestudy.beans.ProductDTO;
import com.johnbwhitejr.target.casestudy.repositories.PriceRepository;
import com.johnbwhitejr.target.casestudy.utils.RedskyClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        CurrentPrice current_price = priceRepository.findById(id).get().getCurrent_price();
        product.setCurrent_price(current_price);
        return product;
    }

    public Price getPriceByProductId(long id) {
        return priceRepository.findById(id).get();
    }

    public ProductDTO getProductById(long id) {
        return redskyClient.getProductById(id);
    }

    public void addPriceToDb(long id, CurrentPrice currentPrice) {
        Price toSave = new Price(id, currentPrice);
        priceRepository.save(toSave);
    }
}
