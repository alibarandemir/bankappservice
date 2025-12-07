package com.alibarandemir.bankappservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
    
    @NotBlank()
    private String name;
    
    @NotBlank()
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String userName;
    
    @NotBlank()
    @Email(message = "Email should be valid")
    private String email;
    
    @NotBlank()
    @Size(min = 6, message = "Şifre en az 6 karakter olmalıdır")
    private String password;
}

