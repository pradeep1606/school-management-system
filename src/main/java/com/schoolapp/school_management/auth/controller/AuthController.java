package com.schoolapp.school_management.auth.controller;

import com.schoolapp.school_management.auth.dto.LoginRequest;
import com.schoolapp.school_management.auth.dto.LoginResponse;
import com.schoolapp.school_management.auth.service.AuthService;
import com.schoolapp.school_management.common.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<?>> login(
            @Valid @RequestBody LoginRequest request) {

        LoginResponse response = authService.login(request);

        if (response == null) {
            return ResponseEntity.ok(
                    ApiResponse.error("Invalid username or password")
            );
        }

        return ResponseEntity.ok(ApiResponse.success("Login successful", response));
    }
}
