package com.johnbwhitejr.target.casestudy.controllers;

import com.google.gson.Gson;

import com.johnbwhitejr.target.casestudy.beans.Price;
import com.johnbwhitejr.target.casestudy.beans.ProductDTO;
import com.johnbwhitejr.target.casestudy.repositories.PriceRepository;
import com.johnbwhitejr.target.casestudy.utils.RedskyClient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest
@RunWith(SpringRunner.class)
public class ProductControllerTest {

    private final long id = 12345;

    @MockBean
    private RedskyClient redskyClient;

    @MockBean
    private PriceRepository priceRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetProduct() throws Exception {
        Price price = new Price();
        ProductDTO product = new ProductDTO();
        product.setCurrent_price(price.getCurrent_price());
        Gson gson = new Gson();
        String jsonString = gson.toJson(product);
        Mockito.when(priceRepository.findById(id)).thenReturn(Optional.of(price));
        Mockito.when(redskyClient.getProductById(id)).thenReturn(product);
        mockMvc.perform(get("/products/12345")).andExpect(content().json(jsonString));
    }
}
