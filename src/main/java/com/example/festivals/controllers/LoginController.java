package com.example.festivals.controllers;

import com.example.festivals.dto.request.LoginRequestDTO;
import com.example.festivals.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {

  private final LoginService loginService;
  public LoginController(LoginService loginService) {
    this.loginService = loginService;
  }

  @PostMapping
  public ResponseEntity execute(@RequestBody LoginRequestDTO user) {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(loginService.execute(user.email(), user.password()));
    } catch(Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
