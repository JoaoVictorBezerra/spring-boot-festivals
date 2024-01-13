package com.example.festivals.dto.request;

public record EmailSenderRequest(
    String to, String subject, String message
) {
}
