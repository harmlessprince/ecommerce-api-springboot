package com.harmlessprince.ecommerceApi.seeders;

import com.harmlessprince.ecommerceApi.auth.AuthenticationService;
import com.harmlessprince.ecommerceApi.auth.RegisterUserRequest;
import com.harmlessprince.ecommerceApi.contracts.ISeeder;
import com.harmlessprince.ecommerceApi.user.User;
import com.harmlessprince.ecommerceApi.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@Service
public class UserSeeder implements ISeeder {
    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;
    public void run() {
        if (userRepository.count() >= 5) {
            return;
        }
        for (int i = 0; i < 5; i++) {
            String email = String.format("test%d@yopmail.com", i);
            if (authenticationService.userExists(email)) {
                continue;
            }
            RegisterUserRequest registerUserRequest = new RegisterUserRequest();
            registerUserRequest.setEmail(email);
            registerUserRequest.setPassword("password");
            authenticationService.signup(registerUserRequest);
        }
    }
}
