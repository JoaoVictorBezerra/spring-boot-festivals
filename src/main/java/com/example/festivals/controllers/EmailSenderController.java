package com.example.festivals.controllers;

import com.example.festivals.dto.request.EmailSenderRequest;
import com.example.festivals.services.EmailSenderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {

  private final EmailSenderService emailSenderService;

  public EmailSenderController(EmailSenderService emailSenderService) {
    this.emailSenderService = emailSenderService;
  }

  @PostMapping("/send")
  public ResponseEntity<String> sendEmail(@RequestBody EmailSenderRequest email) {
    try {
      emailSenderService.sendEmail(email.to(), email.subject(), email.message());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email sent successfully");
    } catch(Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

}
