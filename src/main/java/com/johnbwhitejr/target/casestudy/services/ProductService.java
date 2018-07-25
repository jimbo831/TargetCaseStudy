package com.johnbwhitejr.target.casestudy.services;

import com.johnbwhitejr.target.casestudy.beans.CurrentPrice;
import com.johnbwhitejr.target.casestudy.beans.ProductDTO;

public interface ProductService {

    ProductDTO getProduct(long id);
    ProductDTO updateProduct(long id, CurrentPrice current_price);
}
