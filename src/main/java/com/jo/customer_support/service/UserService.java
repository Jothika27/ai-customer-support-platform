package com.jo.customer_support.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.jo.customer_support.dto.RegisterRequest;
import com.jo.customer_support.dto.RegisterResponse;
import com.jo.customer_support.model.User;
import com.jo.customer_support.repository.UserRepository;
import com.jo.customer_support.utility.UserIDGenerator;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserIDGenerator userIDGenerator;


    public Mono<RegisterResponse> saveUser(RegisterRequest request) {

        if (!request.getPassword().equals(request.getConfirmPassword())) {
            return Mono.error( new IllegalArgumentException( "Passwords do not match"));
        }

        LocalDateTime now =LocalDateTime.now();
        String userId =userIDGenerator.generateUserID();

        return userRepository .existsByEmail(request.getEmail()).flatMap(exists -> {
                    if (exists) {
                        return Mono.error(new IllegalStateException( "Email already exists" ) );

                    }

                    User user = new User();
                    user.setId(userId);
                    user.setFirstName(request.getFirstName());
                    user.setLastName(request.getLastName());
                    user.setEmail(request.getEmail());
                    user.setPassword(request.getPassword());
                    user.setRole(request.getRole());
                    user.setEnabled(true);
                    user.setCreatedAt(now);
                    user.setUpdatedAt(now);

                    return userRepository
                            .save(user)
                            .map(saved -> new RegisterResponse(
                                    saved.getId(),
                                    saved.getFirstName(),
                                    saved.getLastName(),
                                    saved.getEmail(),
                                    saved.getRole(),
                                    "User registered successfully"
                            ));

                });

    }

}