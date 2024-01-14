package com.example.festivals.dto.response;

import com.example.festivals.entities.User;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

@Getter
@Setter
public class RegisterUserResponseDTO {
  private String fullName;
  private String birthday;
  private String email;
  private DateTime createdAt;
  private DateTime updatedAt;

  public RegisterUserResponseDTO(User user) {
    this.fullName = user.getFullName();
    this.birthday = user.getBirthday();
    this.email = user.getEmail();
    this.createdAt = user.getCreatedAt();
    this.updatedAt = user.getUpdatedAt();
  }
}
