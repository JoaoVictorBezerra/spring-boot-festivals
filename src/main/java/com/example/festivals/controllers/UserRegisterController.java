package com.example.festivals.controllers;

import com.example.festivals.dto.request.RegisterUserRequestDTO;
import com.example.festivals.repository.UserRepository;
import com.example.festivals.services.UserRegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class UserRegisterController {

  private final UserRegisterService userRegisterService;
  @Autowired
  public UserRegisterController(UserRegisterService userRegisterService) {
    this.userRegisterService = userRegisterService;
  }

  @PostMapping
  public ResponseEntity execute(@RequestBody @Valid RegisterUserRequestDTO newUser) {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(userRegisterService.execute(newUser));
    } catch(Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
