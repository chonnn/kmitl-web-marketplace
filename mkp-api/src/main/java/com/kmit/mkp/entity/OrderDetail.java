package com.kmit.mkp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderDetail {
    @Id
    private String id;

//    private String orderId;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

//    private String productId;

    private Integer quantity;
    private Double price;
    private Double total;
}
