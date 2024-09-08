package com.harmlessprince.ecommerceApi.auth;

import com.harmlessprince.ecommerceApi.user.User;
import com.harmlessprince.ecommerceApi.user.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public User fromUseRequest(RegisterUserRequest request) {
        return User.
                builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .id(request.getId())
                .build();
    }

    public UserResponse fromUser(User user) {
        return new UserResponse(user.getId(),  user.getEmail(), user.getFullName(), user.getPhoneNumber(), user.getAddress());
    }
}
