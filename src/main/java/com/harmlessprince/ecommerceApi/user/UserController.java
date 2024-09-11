package com.harmlessprince.ecommerceApi.user;

import com.harmlessprince.ecommerceApi.auth.UserMapper;
import com.harmlessprince.ecommerceApi.handler.CustomSuccessResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/profile")
    public ResponseEntity<CustomSuccessResponse<UserResponse>> getUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return ResponseEntity.ok(new CustomSuccessResponse<>( userMapper.fromUser(currentUser), "User profile retrieved"));
    }

    @PatchMapping("/profile/update")
    public ResponseEntity<CustomSuccessResponse<UserResponse>> updateContact(@RequestBody @Valid ProfileUpdateRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        userService.updateProfile(request, currentUser);
        return ResponseEntity.ok(new CustomSuccessResponse<>(userMapper.fromUser(currentUser), "User profile retrieved"));
    }
}
