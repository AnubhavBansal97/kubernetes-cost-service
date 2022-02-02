package com.hackathon.kubernetescostservice.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.hackathon.kubernetescostservice.entity.KubeEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface KubeRepository extends JpaRepository<KubeEntity,String>{


//    @Query(value="select * from kube_cost",nativeQuery = true)
//    List<KubeEntity> getKubeEntitiesList();

    @Query(value="select * from kube_node_cost",nativeQuery = true)
    List<KubeEntity> getKubeEntitiesList();

    @Query(value="select COUNT (DISTINCT cluster_id) from kube_cost",nativeQuery = true)
    Integer getClusterCount();

    @Query(value="select COUNT (DISTINCT pod_id) from kube_cost",nativeQuery = true)
    Integer getPodCount();

    @Query(value="select COUNT (DISTINCT deployment_id) from kube_cost",nativeQuery = true)
    Integer getDeploymentsCount();


    @Query(value="select COUNT (DISTINCT id) from kube_node",nativeQuery = true)
    Integer getNodeCount();

//    @Query(value="select cpu_usage_cost,memory_usage_cost,storage_usage_cost,cpu_usage_cost+memory_usage_cost+storage_usage_cost as total from kube_node_cost ORDER BY total desc ",nativeQuery = true)
//    List<KubeEntity> getTopSpendNodes();



//    @Query(value="select id,SUM(cpu_cost),SUM(memory_cost),SUM(storage_cost),SUM(cpu_cost)+SUM(memory_cost)+SUM(storage_cost) as total from kube_cost GROUP BY cluster_id ORDER BY total desc ",nativeQuery = true)
//    List<KubeEntity> getTopSpendClusters();



}

