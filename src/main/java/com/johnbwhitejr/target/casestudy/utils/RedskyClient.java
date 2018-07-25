package com.johnbwhitejr.target.casestudy.utils;

import com.johnbwhitejr.target.casestudy.beans.Item;
import com.johnbwhitejr.target.casestudy.beans.ProductDTO;
import com.johnbwhitejr.target.casestudy.beans.RedskyResponse;
import com.johnbwhitejr.target.casestudy.exceptions.RedskyException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RedskyClient {

    @Value("${redsky.base.url}")
    private String redskyBaseUrl;

    @Value("${redsky.url.params}")
    private String redskyUrlParams;

    public ProductDTO getProductById(long id) throws RedskyException {
        String url = redskyBaseUrl + id + redskyUrlParams;
        RestTemplate restTemplate = new RestTemplate();
        RedskyResponse redskyResponse = restTemplate.getForObject(url, RedskyResponse.class);
        if (redskyResponse == null) {
            throw new RedskyException("Unable to get product info from Redsky");
        }
        Item item = redskyResponse.getProduct().getItem();
        return new ProductDTO(item.getTcin(), item.getProduct_description().getTitle());
    }

}
