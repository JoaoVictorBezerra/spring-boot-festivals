package com.example.festivals.services.external.ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.example.festivals.services.EmailSenderService;
import org.springframework.stereotype.Service;

@Service
public class AmazonSesService implements EmailSenderService {
  private final AmazonSimpleEmailService amazonSimpleEmailService;

  public AmazonSesService(AmazonSimpleEmailService amazonSimpleEmailService) {
    this.amazonSimpleEmailService = amazonSimpleEmailService;
  }

  @Override
  public void sendEmail(String toEmail, String subject, String body) {
    this.amazonSimpleEmailService.sendEmail(buildEseMessage(toEmail, subject, body));
  }

  private static SendEmailRequest buildEseMessage(String toEmail, String subject, String body) {
    return new SendEmailRequest()
        .withSource("dev.joaovictor@hotmail.com")
        .withDestination(new Destination().withToAddresses(toEmail))
        .withMessage(new Message()
            .withSubject(new Content(subject))
            .withBody(new Body().withText(new Content(body)))
        );
  }
}
