package com.hackathon.kubernetescostservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtilCostResponse {

    private Double allocated;

    private Double utilized;

    private Double cost;
}
