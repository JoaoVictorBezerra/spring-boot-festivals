package com.example.festivals.dto.request;

import com.example.festivals.core.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterUserRequestDTO(
    @NotBlank
    String fullName,
    @NotBlank
    @Size(min = 8, max = 8, message = "O campo 'birthday' deve ter exatamente 8 caracteres numéricos")
    String birthday,
    @NotBlank String email,
    @NotBlank String password,
    @NotBlank UserRole role
) {
}
