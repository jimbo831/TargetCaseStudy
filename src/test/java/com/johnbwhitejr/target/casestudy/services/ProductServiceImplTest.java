package com.johnbwhitejr.target.casestudy.services;

import com.johnbwhitejr.target.casestudy.beans.Price;
import com.johnbwhitejr.target.casestudy.beans.ProductDTO;
import com.johnbwhitejr.target.casestudy.repositories.PriceRepository;
import com.johnbwhitejr.target.casestudy.utils.RedskyClient;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceImplTest {

    private final long id = 12345;
    private ProductDTO product;
    private Price price;

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private RedskyClient redskyClient;

    @Mock
    private PriceRepository priceRepository;

    @Before
    public void setup() {
        product = new ProductDTO();
        price = new Price();
        product.setCurrent_price(price.getCurrent_price());
        Mockito.when(priceRepository.findById(id)).thenReturn(Optional.of(price));
        Mockito.when(redskyClient.getProductById(id)).thenReturn(product);
    }

    @Test
    public void testGetProduct() {
        Assert.assertEquals(productService.getProduct(id), product);
    }

    @Test
    public void testUpdateProduct() {
        Assert.assertEquals(productService.updateProduct(id, price.getCurrent_price()), product);
        Mockito.verify(priceRepository, Mockito.times(1)).save(Mockito.any(Price.class));
    }
}
