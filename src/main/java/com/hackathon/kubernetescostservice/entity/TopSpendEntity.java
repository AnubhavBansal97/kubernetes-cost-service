package com.hackathon.kubernetescostservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TopSpendEntity {

    @Id
    @Column(name = "id",nullable = false)
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "cpu_cost")
    private Double cpuCost;

    @Column(name = "memory_cost")
    private Double memoryCost;

    @Column(name = "storage_cost")
    private Double storageCost;

    @Column(name = "total")
    private Double total;

}
