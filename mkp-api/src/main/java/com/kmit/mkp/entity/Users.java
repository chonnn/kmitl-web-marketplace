package com.kmit.mkp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Users {
    @Id
    private String id;
    private String username;
    private String password;
    private String status;
}
