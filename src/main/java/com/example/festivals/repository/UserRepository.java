package com.example.festivals.repository;

import com.example.festivals.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

  User findByEmail(String email);

  UserDetails findUserById(String id);


}
