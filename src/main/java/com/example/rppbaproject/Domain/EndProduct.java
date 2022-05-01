package com.example.rppbaproject.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Data
@Table(name = "end_products")
@Entity
@NoArgsConstructor
public class EndProduct {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "vendor_code", nullable = false)
    private Integer vendorCode;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "amount", nullable = false)
    private Integer amount;


}