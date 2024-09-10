package com.harmlessprince.ecommerceApi.auth;


import com.harmlessprince.ecommerceApi.exceptions.EmailTakenException;
import com.harmlessprince.ecommerceApi.handler.CustomSuccessResponse;
import com.harmlessprince.ecommerceApi.jwt.JwtService;
import com.harmlessprince.ecommerceApi.user.User;
import com.harmlessprince.ecommerceApi.user.UserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/v1/auth")
public class AuthController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;

    @PostMapping("/signup")
    public ResponseEntity<CustomSuccessResponse<UserResponse>> registerUser(@RequestBody @Valid RegisterUserRequest registerUserRequest) {
        if (authenticationService.userExists(registerUserRequest.getEmail())) {
            throw new EmailTakenException();
        }
        User registeredUser = authenticationService.signup(registerUserRequest);
        CustomSuccessResponse<UserResponse> response = new CustomSuccessResponse<UserResponse>( userMapper.fromUser(registeredUser), "Registration successful");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> registerUser(@RequestBody @Valid LoginRequest loginRequest) {
        User user = authenticationService.login(loginRequest);
        String token = jwtService.generateToken(user);
        LoginResponse loginResponse = new LoginResponse(
                userMapper.fromUser(user),
                token,
                jwtService.getExpirationTime()
        );
        return ResponseEntity.ok(loginResponse);
    }

}
