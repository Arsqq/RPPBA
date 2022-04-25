package com.example.rppbaproject.Domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "end_products")
@Entity
public class EndProduct {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "vendor_code", nullable = false)
    private Integer vendorCode;

    @Lob
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "amount", nullable = false)
    private Integer amount;


}