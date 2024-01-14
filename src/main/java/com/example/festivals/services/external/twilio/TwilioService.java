package com.example.festivals.services.external.twilio;

import com.example.festivals.services.SmsSender;
import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class TwilioService implements SmsSender {
  @Override
  public void sendSms(String cellphone, String body) throws Exception {
    try {
      buildEmailMessage(cellphone, body);
    } catch (TwilioException e) {
      throw new Exception(e);
    }
  }

  private static MessageCreator buildEmailMessage(String cellphone, String body) {
    return Message
        .creator(
            new PhoneNumber(cellphone),
            new PhoneNumber("+14062045953"),
            body
        );
  }
}
