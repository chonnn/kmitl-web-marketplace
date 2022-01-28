package com.kmit.mkp.controller;

import com.kmit.mkp.dto.OrdersDto;
import com.kmit.mkp.entity.Orders;
import com.kmit.mkp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("order")
    public OrdersDto postOrder(@RequestBody OrdersDto ordersDto){
        return orderService.saveOrder(ordersDto);
    }


    @GetMapping("admin/orders")
    public List<OrdersDto> getOrders(){
        return orderService.findOrders();
    }

    @GetMapping("admin/order/{id}")
    public OrdersDto getOrder(@PathVariable String id){
        return orderService.findOrder(id);
    }
}
