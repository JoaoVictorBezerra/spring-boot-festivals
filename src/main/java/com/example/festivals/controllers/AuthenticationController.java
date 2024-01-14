package com.example.festivals.controllers;

import com.example.festivals.dto.request.LoginRequestDTO;
import com.example.festivals.dto.request.RegisterUserRequestDTO;
import com.example.festivals.services.AuthorizationService;
import com.example.festivals.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

  private final AuthorizationService authorizationService;
  private final AuthenticationManager authenticationManager;

  private final UserService userService;
  public AuthenticationController(AuthorizationService authorizationService, AuthenticationManager authenticationManager, UserService userService) {
    this.authorizationService = authorizationService;
    this.authenticationManager = authenticationManager;
    this.userService = userService;
  }

  @PostMapping("/login")
  public ResponseEntity login(@RequestBody LoginRequestDTO user) {
    try {
      var emailAndPassword = new UsernamePasswordAuthenticationToken(user.email(), user.password());
      var auth = this.authenticationManager.authenticate(emailAndPassword);
      return ResponseEntity.status(HttpStatus.OK).body(authorizationService.login(user.email(), user.password()));
    } catch(Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
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
