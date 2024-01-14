package com.example.festivals.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum UserRole {
  ADMIN("admin"),
  USER("user");

  private final String role;
}
