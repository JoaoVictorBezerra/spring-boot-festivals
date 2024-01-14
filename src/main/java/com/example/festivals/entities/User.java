package com.example.festivals.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import java.util.UUID;


@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity(name = "users")
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String fullName;
  private String birthday;
  private String email;
  private String password;
  private DateTime createdAt;
  private DateTime updatedAt;

  public User(String fullName, String birthday, String email, String password) {
    this.fullName = fullName;
    this.birthday = birthday;
    this.email = email;
    this.password = password;
    this.createdAt = DateTime.now();
    this.updatedAt = null;
  }

  public User(UUID id, String fullName, String birthday, String email, String password, DateTime createdAt, DateTime updatedAt) {
    this.id = id;
    this.fullName = fullName;
    this.birthday = birthday;
    this.email = email;
    this.password = password;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public User() {

  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", fullName='" + fullName + '\'' +
        ", birthday='" + birthday + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        '}';
  }
}
