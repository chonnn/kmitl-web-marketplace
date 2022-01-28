package com.kmit.mkp.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class UserToken {
    @Id
    private String id;
    private String userId;
    private String token;
    private String status;
}
