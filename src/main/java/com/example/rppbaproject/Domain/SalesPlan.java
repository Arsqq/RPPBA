package com.example.rppbaproject.Domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Data
@Table(name = "sales_plans")
@Entity
public class SalesPlan {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "deadline", nullable = false)
    private OffsetDateTime deadline;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "end_product_id", nullable = false)
    private Integer endProductId;


}