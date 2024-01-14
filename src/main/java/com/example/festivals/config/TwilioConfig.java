package com.example.festivals.config;

import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfig {

  @Value("${twilio.account.sid}")
  private String ACCOUNT_SID;

  @Value("${twilio.auth.token}")
  private String AUTH_TOKEN;
  @PostConstruct
  public void initTwilio() {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
  }
}
