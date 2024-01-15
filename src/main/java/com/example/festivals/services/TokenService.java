package com.example.festivals.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.festivals.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

  @Value("${api.secret.jwt.key}")
  private String secret;
  public String generateToken(User user) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.create()
          .withIssuer(user.getId())
          .withClaim("role", String.valueOf(user.getRole()))
          .withExpiresAt(generateExpirationDate())
          .sign(algorithm);
    } catch (JWTCreationException e) {
      throw new RuntimeException("Error while generating token", e);
    }
  }

  private Instant generateExpirationDate() {
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
  }

  public String validateToken(String token){
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.require(algorithm)
          .build()
          .verify(token)
          .getIssuer();
    } catch (JWTVerificationException e) {
      return "";
    }
  }
}
