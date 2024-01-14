package com.example.festivals.services;

import com.example.festivals.dto.response.LoginResponseDTO;
import com.example.festivals.entities.User;
import com.example.festivals.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorizationService implements UserDetailsService {
  private final UserRepository userRepository;

  public AuthorizationService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public LoginResponseDTO login(String email, String password) throws Exception {
    Optional<User> userInfos = userRepository.findByEmailAndPassword(email, password);
    User user = userInfos.orElseThrow(() -> new Exception("Nenhum usuário encontrado"));
    return new LoginResponseDTO(user);
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return this.userRepository.findByEmail(email);
  }
}
