package com.jo.customer_support.dto;

import com.jo.customer_support.utility.Role;

public record RegisterResponse(

        String id,

        String firstName,

        String lastName,

        String email,

        Role role,

        String message

){}