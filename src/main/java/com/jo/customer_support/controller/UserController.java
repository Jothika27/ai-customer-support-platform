package com.jo.customer_support.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jo.customer_support.dto.RegisterRequest;
import com.jo.customer_support.dto.RegisterResponse;
import com.jo.customer_support.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;
  
    @PostMapping( "/register")
    public Mono<RegisterResponse> register(@Valid @RequestBody RegisterRequest request){
        return userService.saveUser( request );
    }

  
}
