package com.kmit.mkp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailDto {
    private String productId;
    private Integer quantity;
    private Double price;
    private Double total;
    private String productName;
}
