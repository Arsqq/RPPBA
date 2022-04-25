package com.example.rppbaproject.Domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "orders")
@Entity
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "\"time\"", nullable = false)
    private Integer time;

    @Column(name = "priority", nullable = false)
    private String priority;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "sales_plans_id", nullable = false)
    private Integer salesPlansId;


}