package com.hackathon.kubernetescostservice.repository;

import com.hackathon.kubernetescostservice.entity.TopSpendEntity;
import com.hackathon.kubernetescostservice.entity.TopSpendNodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopSpendNodeRepository extends JpaRepository<TopSpendNodeEntity,String> {

    @Query(value="select id,cpu_usage_cost,memory_usage_cost,storage_usage_cost,cpu_usage_cost+memory_usage_cost+storage_usage_cost as total from kube_node_cost ORDER BY total desc ",nativeQuery = true)
    List<TopSpendNodeEntity> getTopSpendNodes();
    
}
