package com.kmit.mkp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Orders {
    @Id
    private String id;

    private String name;
    private String address1;
    private String address2;
    private String address3;

    private String totalAmount;

    
}
