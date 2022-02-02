package com.hackathon.kubernetescostservice.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.hackathon.kubernetescostservice.entity.KubeEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface KubeRepository extends JpaRepository<KubeEntity,String>{


    @Query(value="select * from kube_cost",nativeQuery = true)
    List<KubeEntity> getKubeEntitiesList();

    @Query(value="select COUNT (DISTINCT cluster_id) from kube_cost",nativeQuery = true)
    Integer getClusterCount();

    @Query(value="select COUNT (DISTINCT pod_id) from kube_cost",nativeQuery = true)
    Integer getPodCount();

    @Query(value="select COUNT (DISTINCT deployment_id) from kube_cost",nativeQuery = true)
    Integer getDeploymentsCount();


    @Query(value="select COUNT (DISTINCT id) from kube_node",nativeQuery = true)
    Integer getNodeCount();
}

