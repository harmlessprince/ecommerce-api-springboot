package com.harmlessprince.ecommerceApi.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Boolean userExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public Boolean userExists(Integer id) {
        return userRepository.findById(id).isPresent();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }
}
