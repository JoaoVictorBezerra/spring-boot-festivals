package com.example.festivals.services;

import com.example.festivals.dto.request.RegisterUserRequestDTO;
import com.example.festivals.dto.response.RegisterUserResponseDTO;
import com.example.festivals.entities.User;
import com.example.festivals.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterService {
  private final UserRepository userRepository;

  public UserRegisterService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public RegisterUserResponseDTO execute(RegisterUserRequestDTO newUser) throws Exception {
    try {
      return new RegisterUserResponseDTO(this.userRepository.save(
          new User(newUser.fullName(), newUser.birthday(), newUser.email(), newUser.password())
      ));
    } catch (Exception e) {
      throw new Exception("Não foi possível registrar o usuário");
    }
  }
}
