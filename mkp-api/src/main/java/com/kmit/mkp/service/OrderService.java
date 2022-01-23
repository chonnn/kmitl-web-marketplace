package com.kmit.mkp.service;

import com.kmit.mkp.dto.OrderDetailDto;
import com.kmit.mkp.dto.OrdersDto;
import com.kmit.mkp.dto.ProductDto;
import com.kmit.mkp.entity.OrderDetail;
import com.kmit.mkp.entity.Orders;
import com.kmit.mkp.entity.Product;
import com.kmit.mkp.mapper.OrderMapper;
import com.kmit.mkp.repository.OrderDetailRepository;
import com.kmit.mkp.repository.OrdersRepository;
import com.kmit.mkp.repository.ProductRepository;
import com.kmit.mkp.util.UUIDGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrdersRepository ordersRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductRepository productRepository;

    private final OrderMapper orderMapper;

    @Transactional
    public OrdersDto saveOrder(OrdersDto ordersDto){
        Orders orders = orderMapper.toOrder(ordersDto);
        orders.setTotalAmount(
                orders.getOrderDetails().stream()
                        .mapToDouble(od -> od.getPrice())
                        .sum()
        );
        orders.getOrderDetails().forEach(od -> od.setOrder(orders));

        ordersRepository.save(orders);
        return ordersDto;
    }

    public List<OrdersDto> findOrders(){
        List<Orders> ordersList = ordersRepository.findAll();
        List<OrdersDto> ordersDtoList = orderMapper.toOrderDtoList(ordersList);
        return ordersDtoList;
    }

    public OrdersDto findOrder(String orderId){
        Orders orders = ordersRepository.findById(orderId).get();

        OrdersDto ordersDto = orderMapper.toOrderDto(orders);
        ordersDto.getOrderDetails().forEach(od -> {
            Product p = productRepository.findById(od.getProductId()).get();
            od.setProductName(p.getName());
        });

        return ordersDto;
    }
}
