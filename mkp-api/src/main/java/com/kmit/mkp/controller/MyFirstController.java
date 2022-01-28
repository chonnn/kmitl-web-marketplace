package com.kmit.mkp.controller;

import com.kmit.mkp.dto.ProductDto;
import com.kmit.mkp.service.MyFirstService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyFirstController {

    private final MyFirstService myFirstService;

    @GetMapping("hello")
    public ProductDto helloSpringBoot(){
        return myFirstService.getProduct();
    }
}
