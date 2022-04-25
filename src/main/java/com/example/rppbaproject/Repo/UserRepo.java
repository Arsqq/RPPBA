package com.example.rppbaproject.Repo;

import com.example.rppbaproject.Domain.User;
import com.example.rppbaproject.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository <User,Long> {
    boolean existsByLoginAndPassword(String login, String password);
    User findById(Integer id);
    User findByLogin(String login);

}
