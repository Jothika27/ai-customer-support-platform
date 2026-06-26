package com.jo.customer_support.dto;

import com.jo.customer_support.utility.Role;

public record LoginResponse(        
        String accessToken,

        String refreshToken,

        String email,

        Role role) {}
