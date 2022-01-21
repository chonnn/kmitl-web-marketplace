package com.kmit.mkp.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Orders {
    @Id
    private String id;

    private String name;
    private String address1;
    private String address2;
    private String address3;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    private Double totalAmount;
}
