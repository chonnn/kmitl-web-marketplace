package com.kmit.mkp.service;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.kmit.mkp.dto.ProductDto;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    public ProductDto getProduct(){
        ProductDto productDto = new ProductDto();
        productDto.setId("UUID");
        productDto.setName("Test Name");
        productDto.setDescription("Test Description");
        productDto.setPrice(199D);

        return productDto;
    }

}
