package com.johnbwhitejr.target.casestudy.services;

import com.johnbwhitejr.target.casestudy.beans.Price;
import com.johnbwhitejr.target.casestudy.beans.ProductDTO;
import com.johnbwhitejr.target.casestudy.repositories.PriceRepository;
import com.johnbwhitejr.target.casestudy.utils.RedskyClient;

import org.junit.Assert;
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

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private RedskyClient redskyClient;

    @Mock
    private PriceRepository priceRepository;

    @Test
    public void testGetPriceByProductId() {
        Price price = new Price();
        Mockito.when(priceRepository.findById(id)).thenReturn(Optional.of(price));
        Assert.assertEquals(productService.getPriceByProductId(id), price);
    }

    @Test
    public void testGetProductById() {
        ProductDTO productDTO = new ProductDTO();
        Mockito.when(redskyClient.getProductById(id)).thenReturn(productDTO);
        Assert.assertEquals(productService.getProductById(id), productDTO);
    }
}
