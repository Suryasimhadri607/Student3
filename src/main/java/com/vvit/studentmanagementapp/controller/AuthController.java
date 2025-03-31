package com.vvit.studentmanagementapp.controller;

import com.vvit.studentmanagementapp.security.JwtRequest;
import com.vvit.studentmanagementapp.security.JwtResponse;
import com.vvit.studentmanagementapp.security.JwtUtil;
import com.vvit.studentmanagementapp.service.UserService;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, UserService userService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody JwtRequest request) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

            // ✅ Load user details
            UserDetails userDetails = userService.loadUserByUsername(request.getEmail());

            // ✅ Generate JWT token with username
            String token = jwtUtil.generateToken(userDetails.getUsername());

            return new JwtResponse(token);

        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid username or password"); // ✅ Handle authentication failure
        } catch (DisabledException e) {
            throw new RuntimeException("User account is disabled");
        } catch (LockedException e) {
            throw new RuntimeException("User account is locked");
        }
    }
}
