package com.schoolapp.school_management.auth.service.impl;

import com.schoolapp.school_management.auth.dto.LoginRequest;
import com.schoolapp.school_management.auth.dto.LoginResponse;
import com.schoolapp.school_management.security.JwtUtil;
import com.schoolapp.school_management.user.entity.User;
import com.schoolapp.school_management.user.repository.UserRepository;
import com.schoolapp.school_management.auth.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByUserName(request.getUserName())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid username or password");
        }

        if (!"ACTIVE".equalsIgnoreCase(user.getStatus())) {
            throw new IllegalStateException("User account is inactive");
        }

        LoginResponse response = new LoginResponse();
        response.setUserId(user.getId());
        response.setUserName(user.getUserName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole().getName());
        response.setSchoolId(user.getSchool().getId());
        response.setStatus(user.getStatus());
        String roleName = user.getRole().getName();
        Long schoolId = user.getSchool().getId();
        String token = JwtUtil.generateToken(user.getId(), user.getUserName(), roleName, schoolId);
        response.setToken(token);
        response.setLoginTime(LocalDateTime.now());

        return response;
    }
}
