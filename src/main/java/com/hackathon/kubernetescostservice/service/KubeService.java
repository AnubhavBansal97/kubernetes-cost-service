package com.hackathon.kubernetescostservice.service;

import com.hackathon.kubernetescostservice.dao.KubeDaoImpl;
import com.hackathon.kubernetescostservice.entity.KubeSummaryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
