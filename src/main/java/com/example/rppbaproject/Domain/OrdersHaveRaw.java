package com.example.rppbaproject.Domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "orders_have_raws")
@Entity
public class OrdersHaveRaw {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "raw_amount", nullable = false)
    private Integer rawAmount;

    @Column(name = "orders_id", nullable = false)
    private Integer ordersId;

    @Column(name = "raws_id", nullable = false)
    private Integer rawsId;


}