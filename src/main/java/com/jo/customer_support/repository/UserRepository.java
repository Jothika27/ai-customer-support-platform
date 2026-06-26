package com.jo.customer_support.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.jo.customer_support.model.User;

import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
   
    Mono<Boolean> existsByEmail(String email);
    Mono<User> findByEmail(String email);
}
