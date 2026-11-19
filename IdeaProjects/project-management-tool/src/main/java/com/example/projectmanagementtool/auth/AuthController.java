package com.example.projectmanagementtool.auth;

import com.example.projectmanagementtool.dto.AuthResponse;
import com.example.projectmanagementtool.dto.UserLoginRequest;
import com.example.projectmanagementtool.dto.UserRegistrationRequest;
import com.example.projectmanagementtool.user.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    public AuthController(UserService userService,AuthService authService){
        this.userService=userService;
        this.authService=authService;
    }
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @Valid @RequestBody UserRegistrationRequest request
            ){
        userService.registerUser(request);
        AuthResponse response=new AuthResponse(
                "User registered successfully",null,null
        );
        return ResponseEntity.ok(response);
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @Valid @RequestBody UserLoginRequest request
            ){
        authService.login(request);
        AuthResponse response=new AuthResponse("Login successful",null,null);
        return ResponseEntity.ok(response);
    }

}
