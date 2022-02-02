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
public class TopSpendNodeEntity {

    @Id
    @Column(name = "id",nullable = false)
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "cpu_usage_cost")
    private Double cpuUsageCost;

    @Column(name = "memory_usage_cost")
    private Double memoryUsageCost;

    @Column(name = "storage_usage_cost")
    private Double storageUsageCost;

    @Column(name = "total")
    private Double total;
}
