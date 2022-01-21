package com.kmit.mkp.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

public class UUIDGenerator {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
