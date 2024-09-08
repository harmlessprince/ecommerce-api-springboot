package com.harmlessprince.ecommerceApi.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User updateProfile(ProfileUpdateRequest contactAddressRequest, User user) {
        user.setAddress(contactAddressRequest.address());
        user.setFullName(contactAddressRequest.fullName());
        user.setPhoneNumber(contactAddressRequest.phoneNumber());
        return userRepository.save(user);
    }
}
