package com.example.rppbaproject.Domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "raws")
@Entity
public class Raw {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "vendor_code", nullable = false)
    private Integer vendorCode;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "parametr", nullable = false)
    private String parametr;


}