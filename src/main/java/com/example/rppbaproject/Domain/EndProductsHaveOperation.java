package com.example.rppbaproject.Domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "end_products_have_operations")
@Entity
public class EndProductsHaveOperation {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "serial_number", nullable = false)
    private Integer serialNumber;

    @Column(name = "end_product_id", nullable = false)
    private Integer endProductId;

    @Column(name = "operation_id", nullable = false)
    private Integer operationId;

}