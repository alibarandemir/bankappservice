package com.alibarandemir.bankappservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibarandemir.bankappservice.dto.ApiResponse;
import com.alibarandemir.bankappservice.dto.AuthResponse;
import com.alibarandemir.bankappservice.dto.LoginRequest;
import com.alibarandemir.bankappservice.dto.RegisterRequest;
import com.alibarandemir.bankappservice.service.IAuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final IAuthService authService;
    
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AuthResponse>> register(@Valid @RequestBody RegisterRequest request) {
        try {
            AuthResponse authResponse = authService.register(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ApiResponse.success("Kullanıcı başarıyla kaydedildi", authResponse));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error(e.getMessage()));
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@Valid @RequestBody LoginRequest request) {
        try {
            AuthResponse authResponse = authService.login(request);
            return ResponseEntity.ok(ApiResponse.success("Giriş başarılı", authResponse));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(ApiResponse.error("Kullanıcı adı veya şifre hatalı"));
        }
    }
    
    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<String>> logout() {
        // Logout işlemi client tarafında token'ı silmekle yapılır
        return ResponseEntity.ok(ApiResponse.success("Çıkış başarılı", null));
    }
}

