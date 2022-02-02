package com.hackathon.kubernetescostservice.entity;

import com.hackathon.kubernetescostservice.enums.CloudName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
//@Table(name="kube_cost")
public class KubeEntity {

    @Id
    @Column(name = "id",nullable = false)
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "pod_id",nullable = false)
    @Type(type = "pg-uuid")
    private UUID podId;

    @Column(name = "container_id")
    @Type(type = "pg-uuid")
    private UUID containerId;

    @Column(name = "service_id")
    @Type(type = "pg-uuid")
    private UUID serviceId;

    @Column(name = "namespace_id")
    @Type(type = "pg-uuid")
    private UUID namespaceId;

    @Column(name = "cluster_id")
    @Type(type = "pg-uuid")
    private UUID clusterId;

    @Column(name = "deployment_id")
    @Type(type = "pg-uuid")
    private UUID deploymentId;

    @Column(name = "provider",nullable = false)
    @Enumerated(EnumType.STRING)
    private CloudName provider;

    @Column(name = "cpu_cost")
    private Double cpuCost;

    @Column(name = "memory_cost")
    private Double memoryCost;

    @Column(name = "storage_cost")
    private Double storageCost;

    @Column(name = "cpu_usage")
    private Double cpuUsage;

    @Column(name = "memory_usage")
    private Double memoryUsage;

    @Column(name = "storage_usage")
    private Double storageUsage;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

}

