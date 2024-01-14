package com.example.festivals.services;

import com.example.festivals.dto.response.LoginResponseDTO;
import com.example.festivals.entities.User;
import com.example.festivals.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
  private final UserRepository userRepository;

  public LoginService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public LoginResponseDTO execute(String email, String password) throws Exception {
    Optional<User> userInfos = userRepository.findByEmailAndPassword(email, password);
    User user = userInfos.orElseThrow(() -> new Exception("Nenhum usuário encontrado"));
    return new LoginResponseDTO(user);
  }
}
