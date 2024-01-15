package com.example.festivals.dto.request;

import com.example.festivals.core.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterUserRequestDTO(
    @NotBlank(message = "Field name can't be null")
    String name,
    @NotBlank(message = "Field email can't be null")
    String email,
    @NotBlank
    @Size(min = 8, max = 8, message = "Field birthday must be 8 characters, Example: 20010201")
    String birthday,
    @NotBlank(message = "Field password can't be null")
    String password,
    UserRole role
) {
}
