package com.example.festivals.services;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

  private AmazonSimpleEmailService amazonSimpleEmailService;

  @Autowired
  public EmailSenderService(AmazonSimpleEmailService amazonSimpleEmailService) {
    this.amazonSimpleEmailService = amazonSimpleEmailService;
  }

  public void sendEmail(String toEmail, String subject, String body) throws Exception {
    SendEmailRequest request = new SendEmailRequest()
        .withSource("dev.joaovictor@hotmail.com")
        .withDestination(new Destination().withToAddresses(toEmail))
        .withMessage(new Message()
            .withSubject(new Content(subject))
            .withBody(new Body().withText(new Content(body)))
        );

    try {
      amazonSimpleEmailService.sendEmail(request);
    } catch (AmazonServiceException ex) {
      throw new Exception("Email sending failed");
    }
  }

}
