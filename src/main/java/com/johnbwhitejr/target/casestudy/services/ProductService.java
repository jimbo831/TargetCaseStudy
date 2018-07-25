package com.johnbwhitejr.target.casestudy.services;

import com.johnbwhitejr.target.casestudy.beans.CurrentPrice;
import com.johnbwhitejr.target.casestudy.beans.Price;
import com.johnbwhitejr.target.casestudy.beans.ProductDTO;

public interface ProductService {

    Price getPriceByProductId(long id);
    void addPriceToDb(long id, CurrentPrice currentPrice);
    ProductDTO getProductById(long id);
}
