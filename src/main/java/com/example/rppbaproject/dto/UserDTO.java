package com.example.rppbaproject.dto;

import com.example.rppbaproject.Domain.Role;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Component
@Data
public class UserDTO {

    private Integer id;

    private String login;

    private String password;

    private String name;

    private String surname;

    private Role role;

}
