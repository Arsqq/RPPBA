package com.example.rppbaproject.Repo;

import com.example.rppbaproject.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User,Long> {
    boolean existsByLoginAndPassword(String login, String password);
}
