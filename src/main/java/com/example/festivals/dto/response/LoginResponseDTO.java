package com.example.festivals.dto.response;

import com.example.festivals.entities.User;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

@Getter
@Setter
public class LoginResponseDTO {
  private String token;
  private String fullName;
  private String birthday;
  private String email;
//  private DateTime createdAt;
//  private DateTime updatedAt;

  public LoginResponseDTO(User user) {
    this.token = "123456789";
    this.fullName = user.getFullName();
    this.birthday = user.getBirthday();
    this.email = user.getEmail();
//    this.createdAt = user.getCreatedAt();
//    this.updatedAt = user.getUpdatedAt();
  }
}
