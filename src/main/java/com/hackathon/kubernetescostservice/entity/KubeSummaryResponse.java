package com.hackathon.kubernetescostservice.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.hackathon.kubernetescostservice.enums.CloudName;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KubeSummaryResponse {

    private Integer totalClusters;

    private Integer totalNodes;

    private Integer totalDeployments;

    private Integer totalPods;

    private Map<CloudName,UtilCostResponse> storage;

    private Map<CloudName,UtilCostResponse> memory;

    private Map<CloudName,UtilCostResponse> compute;

    private Map<CloudName,UtilCostResponse> network;

}
