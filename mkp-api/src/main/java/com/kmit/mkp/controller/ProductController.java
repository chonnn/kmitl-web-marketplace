package com.kmit.mkp.controller;

import com.kmit.mkp.dto.ProductDto;
import com.kmit.mkp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("products")
    public List<ProductDto> getProducts(){
        return productService.findProducts();
    }

    @PostMapping("product")
    public ProductDto postProduct(@RequestBody ProductDto productDto){
        return productService.saveProduct(productDto);
    }

    @GetMapping("product/{id}")
    public ProductDto getProduct(@PathVariable String id){
        return productService.findProduct(id);
    }

}
