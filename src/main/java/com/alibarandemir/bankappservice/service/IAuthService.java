package com.alibarandemir.bankappservice.service;

import com.alibarandemir.bankappservice.dto.AuthResponse;
import com.alibarandemir.bankappservice.dto.LoginRequest;
import com.alibarandemir.bankappservice.dto.RegisterRequest;

public interface IAuthService {
    
    AuthResponse register(RegisterRequest request);
    
    AuthResponse login(LoginRequest request);
    
    void logout(String token);
}

