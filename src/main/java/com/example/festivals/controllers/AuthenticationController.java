package com.example.festivals.controllers;

import com.example.festivals.dto.ErrorResponseDTO;
import com.example.festivals.dto.request.AuthenticationDTO;
import com.example.festivals.dto.request.RegisterUserRequestDTO;
import com.example.festivals.services.AuthorizationService;
import com.example.festivals.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

  private final UserService userService;

  public AuthenticationController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO user) {
    try {
      return ResponseEntity.ok(userService.login(user));
    } catch(Exception e) {
      return ResponseEntity.status(400).body(new ErrorResponseDTO(e.getMessage()));
    }
  }


  @PostMapping("/register")
  public ResponseEntity execute(@RequestBody @Valid RegisterUserRequestDTO newUser) {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(userService.register(newUser));
    } catch(Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
