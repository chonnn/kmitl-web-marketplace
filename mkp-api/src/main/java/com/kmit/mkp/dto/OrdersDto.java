package com.kmit.mkp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrdersDto {
    private String id;
    private String name;
    private String address1;
    private String address2;
    private String address3;
    private List<OrderDetailDto> orderDetails;
    private Double totalAmount;
}
