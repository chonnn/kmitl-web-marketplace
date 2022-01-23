package com.kmit.mkp.service;

import com.kmit.mkp.dto.ProductDto;
import com.kmit.mkp.entity.Product;
import com.kmit.mkp.mapper.ProductMapper;
import com.kmit.mkp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDto saveProduct(ProductDto productDto){
        productRepository.save(productMapper.mapToProduct(productDto));

        return productDto;
    }

    public List<ProductDto> findProducts(){
        List<Product> products = productRepository.findAll();

        return productMapper.mapToProductDtoList(products);
    }

    public ProductDto findProduct(String id){
        Product product = productRepository.findById(id).get();

        return productMapper.mapToProductDto(product);
    }

}
