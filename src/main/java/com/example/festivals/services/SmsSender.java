package com.example.festivals.services;
import org.springframework.stereotype.Service;

@Service
public interface SmsSender {
  void sendSms(String cellphone, String body) throws Exception;
}
