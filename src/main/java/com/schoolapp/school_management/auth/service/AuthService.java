package com.schoolapp.school_management.auth.service;

import com.schoolapp.school_management.auth.dto.LoginRequest;
import com.schoolapp.school_management.auth.dto.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);
}
