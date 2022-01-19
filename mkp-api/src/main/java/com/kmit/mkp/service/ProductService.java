package com.kmit.mkp.service;

import com.kmit.mkp.dto.ProductDto;
import com.kmit.mkp.entity.Product;
import com.kmit.mkp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> findProducts(){
        List<Product> products = productRepository.findAll();

        List<ProductDto> productDtos = new ArrayList<>();
        for (Product item:products) {
            ProductDto productDto = new ProductDto();
            productDto.setId(item.getId());
            productDto.setName(item.getName());
            productDto.setDescription(item.getDescription());
            productDto.setPrice(item.getPrice());

            productDtos.add(productDto);
        }

        return productDtos;
    }

    public ProductDto findProduct(String id){
        Product product = productRepository.findById(id).get();

        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());

        return productDto;
    }

    public ProductDto saveProduct(ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());

        productRepository.save(product);

        return productDto;
    }

}
