package com.example.festivals.dto.response;

import com.example.festivals.core.enums.UserRole;
import com.example.festivals.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserResponseDTO {
  private String login;
  private UserRole role;

  public RegisterUserResponseDTO(User user) {
    this.login = user.getEmail();
    this.role = user.getRole();
  }
}
