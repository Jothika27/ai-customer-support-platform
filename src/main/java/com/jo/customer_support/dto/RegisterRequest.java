package com.jo.customer_support.dto;


import com.jo.customer_support.utility.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
@NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    private String email;

    @Size(min = 8)
    private String password;

    private String confirmPassword;

    @NotNull
    private Role role;
}
