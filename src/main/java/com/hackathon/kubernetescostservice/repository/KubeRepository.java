package com.hackathon.kubernetescostservice.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.hackathon.kubernetescostservice.entity.KubeEntity;

@Repository
public interface KubeRepository extends JpaRepository<KubeEntity,String>{


}

