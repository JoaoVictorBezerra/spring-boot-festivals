package com.example.festivals.services;

import com.example.festivals.core.enums.UserRole;
import com.example.festivals.dto.request.AuthenticationDTO;
import com.example.festivals.dto.request.RegisterUserRequestDTO;
import com.example.festivals.dto.response.LoginResponseDTO;
import com.example.festivals.dto.response.RegisterUserResponseDTO;
import com.example.festivals.entities.User;
import com.example.festivals.repository.UserRepository;
import org.joda.time.DateTime;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final AuthenticationManager authenticationManager;
  private final TokenService tokenService;

  public UserService(UserRepository userRepository, AuthenticationManager authenticationManager, TokenService tokenService) {
    this.userRepository = userRepository;
    this.authenticationManager = authenticationManager;
    this.tokenService = tokenService;

  }

  public RegisterUserResponseDTO register(RegisterUserRequestDTO newUser) throws Exception {
    checkUserRegister(newUser);
    String encryptedPassword = new BCryptPasswordEncoder().encode(newUser.password());
    return new RegisterUserResponseDTO(this.userRepository.save(
        buildUserWithEncryptedPassword(newUser, encryptedPassword)
    ));
  }

  public LoginResponseDTO login(AuthenticationDTO data) {
      var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
      var auth = authenticationManager.authenticate(usernamePassword);
      String token = tokenService.generateToken((User) auth.getPrincipal());
      User user = (User) auth.getPrincipal();
      return new LoginResponseDTO(user.getId(), user.getEmail(), user.getBirthday(), String.valueOf(user.getRole()), user.getCreatedAt(), user.getUpdatedAt(), token);
  }

  private static User buildUserWithEncryptedPassword(RegisterUserRequestDTO newUser, String encryptedPassword) {
    return new User(newUser.name(), newUser.email(), encryptedPassword, newUser.birthday(), newUser.role(), DateTime.now().toString());
  }

  private void checkUserRegister(RegisterUserRequestDTO newUser) throws Exception {
    if(this.userRepository.findByEmail(newUser.email()) != null) {
      throw new Exception("User already registered");
    }
  }
}
