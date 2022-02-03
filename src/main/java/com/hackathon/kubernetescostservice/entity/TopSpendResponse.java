package com.hackathon.kubernetescostservice.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TopSpendResponse {

    private Double cpuUsage;

    private Double memoryUsage;

    private Double storageUsage;

    private Double storageCost;

    private Double cpuCost;

    private Double memoryCost;

    private Double storageTotal;

    private Double memoryTotal;

    private Double cpuTotal;

    private Double total;
}
