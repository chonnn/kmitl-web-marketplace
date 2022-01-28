package com.kmit.mkp.controller;

import com.kmit.mkp.dto.ProductDto;
import com.kmit.mkp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("products")
    public List<ProductDto> getProducts(){
        return productService.findProducts();
    }


    @GetMapping("admin/products")
    public List<ProductDto> getAdminProducts(){
        return productService.findProducts();
    }

    @PostMapping("admin/product")
    public ProductDto postProduct(@RequestBody ProductDto productDto){
        return productService.saveProduct(productDto);
    }

    @GetMapping("admin/product/{id}")
    public ProductDto getProduct(@PathVariable String id){
        return productService.findProduct(id);
    }

}
