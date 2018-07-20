package com.johnbwhitejr.target.casestudy.services;

import com.johnbwhitejr.target.casestudy.beans.Price;

public interface ProductService {

    Price getPriceByProductId(long id);
}
