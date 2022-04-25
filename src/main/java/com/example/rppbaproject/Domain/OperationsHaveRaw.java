package com.example.rppbaproject.Domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "operations_have_raws")
@Entity
public class OperationsHaveRaw {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "raw_amount", nullable = false)
    private Integer rawAmount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "operations_id", nullable = false)
    private Operation operations;

    @ManyToOne(optional = false)
    @JoinColumn(name = "raw_id", nullable = false)
    private Raw raw;


}