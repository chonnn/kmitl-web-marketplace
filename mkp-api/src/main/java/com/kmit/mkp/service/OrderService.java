package com.kmit.mkp.service;

import com.kmit.mkp.dto.OrderDetailDto;
import com.kmit.mkp.dto.OrdersDto;
import com.kmit.mkp.dto.ProductDto;
import com.kmit.mkp.entity.OrderDetail;
import com.kmit.mkp.entity.Orders;
import com.kmit.mkp.entity.Product;
import com.kmit.mkp.repository.OrderDetailRepository;
import com.kmit.mkp.repository.OrdersRepository;
import com.kmit.mkp.repository.ProductRepository;
import com.kmit.mkp.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public OrdersDto saveOrder(OrdersDto ordersDto){

        ordersDto.setId(UUIDGenerator.getUUID());

        Orders orders = new Orders();
        orders.setId(ordersDto.getId());
        orders.setName(ordersDto.getName());
        orders.setOrderDetails(new ArrayList<>());

        OrderDetail orderDetail;
        Product product;
        Double total = 0.0;

        for(OrderDetailDto orderDetailDto: ordersDto.getOrderDetails()){
            product = productRepository.findById(orderDetailDto.getProductId()).get();

            orderDetail = new OrderDetail();
            orderDetail.setId(UUIDGenerator.getUUID());
            orderDetail.setOrder(orders);

            orderDetail.setProduct(product);
            orderDetail.setPrice(product.getPrice());

            orderDetailDto.setPrice(product.getPrice());

            total += product.getPrice();

            orders.getOrderDetails().add(orderDetail);

        }
        orders.setTotalAmount(total);
        ordersRepository.save(orders);
        return ordersDto;
    }

    public List<OrdersDto> findOrders(){
        List<Orders> ordersList = ordersRepository.findAll();

        List<OrdersDto> ordersDtoList = new ArrayList<>();
        OrdersDto ordersDto;
        OrderDetailDto orderDetailDto;

        for (Orders orders: ordersList) {
            ordersDto = new OrdersDto();
            ordersDto.setId(orders.getId());
            ordersDto.setName(orders.getName());
            ordersDto.setOrderDetails(new ArrayList<>());
            ordersDto.setTotalAmount(orders.getTotalAmount());
            ordersDtoList.add(ordersDto);
            for (OrderDetail orderDetail :orders.getOrderDetails()) {
                orderDetailDto = new OrderDetailDto();
                orderDetailDto.setProductId(orderDetail.getOrder().getId());
                orderDetailDto.setProductName(orderDetail.getProduct().getName());
                orderDetailDto.setPrice(orderDetail.getPrice());

                ordersDto.getOrderDetails().add(orderDetailDto);
            }
        }
        return ordersDtoList;
    }

    public OrdersDto findOrder(String orderId){
        Orders orders = ordersRepository.findById(orderId).get();

        OrdersDto ordersDto = new OrdersDto();;
        OrderDetailDto orderDetailDto;

        ordersDto.setId(orders.getId());
        ordersDto.setName(orders.getName());
        ordersDto.setTotalAmount(orders.getTotalAmount());
        ordersDto.setOrderDetails(new ArrayList<>());
        for (OrderDetail orderDetail :orders.getOrderDetails()) {
            orderDetailDto = new OrderDetailDto();
            orderDetailDto.setProductId(orderDetail.getOrder().getId());
            orderDetailDto.setProductName(orderDetail.getProduct().getName());
            orderDetailDto.setPrice(orderDetail.getPrice());

            ordersDto.getOrderDetails().add(orderDetailDto);
        }

        return ordersDto;
    }
}
