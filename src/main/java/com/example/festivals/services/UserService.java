package com.example.festivals.services;

import com.example.festivals.dto.request.RegisterUserRequestDTO;
import com.example.festivals.dto.response.RegisterUserResponseDTO;
import com.example.festivals.entities.User;
import com.example.festivals.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public RegisterUserResponseDTO register(RegisterUserRequestDTO newUser) throws Exception {
    checkUserRegister(newUser);
    String encryptedPassword = new BCryptPasswordEncoder().encode(newUser.password());
    return new RegisterUserResponseDTO(this.userRepository.save(
        buildUserWithEncryptedPassword(newUser, encryptedPassword)
    ));
  }

  private static User buildUserWithEncryptedPassword(RegisterUserRequestDTO newUser, String encryptedPassword) {
    return new User(newUser.fullName(), newUser.birthday(), newUser.email(), encryptedPassword, newUser.role());
  }

  private void checkUserRegister(RegisterUserRequestDTO newUser) throws Exception {
    if(this.userRepository.findByEmail(newUser.email()) != null) {
      throw new Exception("User already registered");
    }
  }
}
