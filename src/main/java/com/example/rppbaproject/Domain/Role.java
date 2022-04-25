package com.example.rppbaproject.Domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "roles")
@Entity
public class Role {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;


}