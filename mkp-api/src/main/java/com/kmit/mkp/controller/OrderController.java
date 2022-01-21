package com.kmit.mkp.controller;

import com.kmit.mkp.dto.OrdersDto;
import com.kmit.mkp.entity.Orders;
import com.kmit.mkp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("order")
    public OrdersDto postOrder(@RequestBody OrdersDto ordersDto){
        return orderService.saveOrder(ordersDto);
    }

    @GetMapping("orders")
    public List<OrdersDto> getOrders(){
        return orderService.findOrders();
    }

    @GetMapping("order/{id}")
    public OrdersDto getOrder(@PathVariable String id){
        return orderService.findOrder(id);
    }
}
