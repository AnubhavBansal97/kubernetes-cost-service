package com.hackathon.kubernetescostservice.dao;

import com.hackathon.kubernetescostservice.entity.KubeEntity;
import com.hackathon.kubernetescostservice.entity.KubeSummaryResponse;
import com.hackathon.kubernetescostservice.entity.UtilCostResponse;
import com.hackathon.kubernetescostservice.enums.CloudName;
import com.hackathon.kubernetescostservice.repository.KubeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Component
public class KubeDaoImpl {


    private final KubeRepository kubeRepository;

    @Autowired
    public KubeDaoImpl(KubeRepository kubeRepository) {
        this.kubeRepository = kubeRepository;
    }

    public KubeSummaryResponse getKubeSummary() throws Exception{
        try{
            KubeSummaryResponse kubeSummaryResponse=new KubeSummaryResponse();
            Integer totalClusters=this.kubeRepository.getClusterCount();
            Integer totalNodes=this.kubeRepository.getNodeCount();
            Integer totalPods=this.kubeRepository.getPodCount();
            Integer totalDeployments=this.kubeRepository.getDeploymentsCount() ;

            List<KubeEntity> kList=this.kubeRepository.getKubeEntitiesList();
            Map<CloudName, UtilCostResponse> storageMp=new HashMap<>();
            Map<CloudName, UtilCostResponse> memoryMp=new HashMap<>();
            Map<CloudName, UtilCostResponse> cpuMp=new HashMap<>();

            for(KubeEntity kItem:kList){
                UtilCostResponse storageVal=storageMp.get(kItem.getProvider());
                UtilCostResponse memoryVal=memoryMp.get(kItem.getProvider());
                UtilCostResponse cpuVal=cpuMp.get(kItem.getProvider());

                UtilCostResponse storageRes=new UtilCostResponse();
                storageRes.setUtilized((storageVal==null ? 0: storageVal.getUtilized())+kItem.getStorageUsage());
                storageRes.setCost((storageVal==null ? 0: storageVal.getCost())+kItem.getStorageCost());
                storageMp.put(kItem.getProvider(),storageRes);

                UtilCostResponse memoryRes=new UtilCostResponse();
                memoryRes.setUtilized((memoryVal==null ? 0: memoryVal.getUtilized())+kItem.getMemoryUsage());
                memoryRes.setCost((memoryVal==null ? 0: memoryVal.getCost())+kItem.getMemoryCost());
                memoryMp.put(kItem.getProvider(),memoryRes);

                UtilCostResponse computeRes=new UtilCostResponse();
                computeRes.setUtilized((cpuVal==null ? 0: cpuVal.getUtilized())+kItem.getCpuUsage());
                computeRes.setCost((cpuVal==null ? 0: cpuVal.getCost())+kItem.getCpuCost());
                cpuMp.put(kItem.getProvider(),computeRes);
            }

            return kubeSummaryResponse.builder()
                    .memory(memoryMp)
                    .storage(storageMp)
                    .compute(cpuMp)
                    .totalClusters(totalClusters)
                    .totalDeployments(totalDeployments)
                    .totalPods(totalPods)
                    .totalNodes(totalNodes)
                    .build();

        }catch(Exception e){
            log.error("Encountered an exception while getting  kube metadata.",e);
            throw  e;
        }
    }
}
