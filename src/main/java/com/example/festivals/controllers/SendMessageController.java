package com.example.festivals.controllers;

import com.example.festivals.dto.request.SmsSenderRequestDTO;
import com.example.festivals.services.SmsSender;
import com.example.festivals.services.external.twilio.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sms")
public class SendMessageController {

  private final SmsSender sendMessageService;

  @Autowired
  public SendMessageController(TwilioService sendMessageService) {
    this.sendMessageService = sendMessageService;
  }

  @PostMapping("/send")
  public ResponseEntity<String> sendSms(@RequestBody SmsSenderRequestDTO cellphone) {
    try {
      this.sendMessageService.sendSms(cellphone.cellphone(), cellphone.body());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sms sent successfully");
    } catch(Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
