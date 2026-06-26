package com.jo.customer_support.utility;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class UserIDGenerator {

    public String generateUserID(){
        return "USR"+UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
