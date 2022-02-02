package com.hackathon.kubernetescostservice.service;

import com.hackathon.kubernetescostservice.dao.KubeDaoImpl;
import com.hackathon.kubernetescostservice.entity.KubeSummaryResponse;
import com.hackathon.kubernetescostservice.entity.TopSpendResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class KubeService {

    private final KubeDaoImpl kubeDao;

    public KubeSummaryResponse getSummary() throws  Exception{
        try {

            KubeSummaryResponse kubeSummaryResponse=this.kubeDao.getKubeSummary();
            return kubeSummaryResponse;

        } catch(Exception e){
            log.error("Unable to fetch dashboard summary", e);
            throw  e;
        }
    }

    public List<TopSpendResponse> getTopSpendNodes() throws Exception{
        try {
            List<TopSpendResponse> topSpendNodesResponse=this.kubeDao.getTopSpendByNodes();
            return topSpendNodesResponse;
        } catch(Exception e){
            log.error("Unable to fetch the top spend nodes", e);
            throw  e;
        }
    }

    public List<TopSpendResponse> getTopSpendClusters() throws Exception{
        try {
            List<TopSpendResponse> topSpendNodesResponse=this.kubeDao.getTopSpendClusters();
            return topSpendNodesResponse;
        } catch(Exception e){
            log.error("Unable to fetch the top spend nodes", e);
            throw  e;
        }
    }
}
