package com.auth.controller;

import com.auth.dto.LoginRequest;
import com.auth.dto.LoginResponse;
import com.auth.entity.User;
import com.auth.jwt.JwtUtil;
import com.auth.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody User user) {

        User existing = userRepo.findByUsername(user.getUsername());
        if(existing != null) {
            return "User already exists!";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);

        return "Registered Successfully!";
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        User dbUser = userRepo.findByUsername(request.getUsername());

        if(dbUser == null) {
            return new LoginResponse("INVALID");
        }

        if(passwordEncoder.matches(request.getPassword(), dbUser.getPassword())) {
            String token = jwtUtil.generateToken(dbUser.getUsername());
            return new LoginResponse(token);
        }

        return new LoginResponse("INVALID");
    }
}