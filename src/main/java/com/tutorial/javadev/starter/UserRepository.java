package com.tutorial.javadev.starter;

import com.tutorial.javadev.starter.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByLastName(String lastName);
}
