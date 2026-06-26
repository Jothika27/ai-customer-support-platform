package com.jo.customer_support.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class LoginRequest {
    @Email
    private String email;

    private String password;
}
