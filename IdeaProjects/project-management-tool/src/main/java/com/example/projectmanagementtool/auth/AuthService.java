package com.example.projectmanagementtool.auth;

import com.example.projectmanagementtool.dto.AuthResponse;
import com.example.projectmanagementtool.dto.UserLoginRequest;
import com.example.projectmanagementtool.jwt.JwtService;
import com.example.projectmanagementtool.user.User;
import com.example.projectmanagementtool.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public AuthService(UserRepository userRepository,PasswordEncoder passwordEncoder,JwtService jwtService){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
        this.jwtService=jwtService;
    }
    public AuthResponse login(UserLoginRequest request){
        User user=userRepository.findByEmail(request.getEmail())
                .orElseThrow(()->
                        new RuntimeException(
                                "Invalid email or password"
                        ));
        boolean passwordMatches=passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );
        if(!passwordMatches)
            throw new RuntimeException("Invalid email or password");
        String token=jwtService.generateToken(user.getEmail());
        return new AuthResponse("Login successful",token,"Bearer");
    }
}
