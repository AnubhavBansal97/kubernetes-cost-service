package com.hackathon.kubernetescostservice.repository;

import com.hackathon.kubernetescostservice.entity.KubeEntity;
import com.hackathon.kubernetescostservice.entity.TopSpendEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopSpendRepository extends JpaRepository<TopSpendEntity,String> {

    @Query(value="select cluster_id as id,SUM(cpu_cost) as cpu_cost,SUM(memory_cost) as memory_cost,SUM(storage_cost) as storage_cost,SUM(cpu_cost)+SUM(memory_cost)+SUM(storage_cost) as total from kube_cost GROUP BY cluster_id ORDER BY total desc ",nativeQuery = true)
    List<TopSpendEntity> getTopSpendClusters();

}
