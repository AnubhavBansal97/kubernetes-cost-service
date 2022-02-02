package com.hackathon.kubernetescostservice.dao;

import com.hackathon.kubernetescostservice.entity.*;
import com.hackathon.kubernetescostservice.enums.CloudName;
import com.hackathon.kubernetescostservice.repository.KubeRepository;
import com.hackathon.kubernetescostservice.repository.TopSpendRepository;
import com.hackathon.kubernetescostservice.repository.TopSpendNodeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
public class KubeDaoImpl {


    private final KubeRepository kubeRepository;
    private final TopSpendRepository topSpendRepository;
    private final TopSpendNodeRepository topSpendNodeRepository;

    @Autowired
    public KubeDaoImpl(KubeRepository kubeRepository, TopSpendRepository topSpendRepository, TopSpendNodeRepository topSpendNodeRepository) {

        this.kubeRepository = kubeRepository;
        this.topSpendRepository= topSpendRepository;
        this.topSpendNodeRepository=topSpendNodeRepository;
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
                storageRes.setAllocated((storageVal==null ? 0: storageVal.getAllocated())+kItem.getStorageTotal());
                storageMp.put(kItem.getProvider(),storageRes);

                UtilCostResponse memoryRes=new UtilCostResponse();
                memoryRes.setUtilized((memoryVal==null ? 0: memoryVal.getUtilized())+kItem.getMemoryUsage());
                memoryRes.setCost((memoryVal==null ? 0: memoryVal.getCost())+kItem.getMemoryCost());
                memoryRes.setAllocated((memoryVal==null ? 0: memoryVal.getAllocated())+kItem.getMemoryTotal());
                memoryMp.put(kItem.getProvider(),memoryRes);

                UtilCostResponse computeRes=new UtilCostResponse();
                computeRes.setUtilized((cpuVal==null ? 0: cpuVal.getUtilized())+kItem.getCpuUsage());
                computeRes.setCost((cpuVal==null ? 0: cpuVal.getCost())+kItem.getCpuCost());
                computeRes.setAllocated((cpuVal==null ? 0: cpuVal.getAllocated())+kItem.getCpuTotal());
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

    public List<TopSpendResponse> getTopSpendByNodes() throws Exception{
        try{

            List<TopSpendNodeEntity> kList=this.topSpendNodeRepository.getTopSpendNodes();
            List<TopSpendResponse> topSpendResponseList=new ArrayList<>();

            for(TopSpendNodeEntity kItem:kList){

                TopSpendResponse topSpendItem=new TopSpendResponse();

                topSpendItem.setStorageUsage(kItem.getStorageUsageCost());
                topSpendItem.setMemoryUsage(kItem.getMemoryUsageCost());
                topSpendItem.setCpuUsage(kItem.getCpuUsageCost());
                topSpendResponseList.add(topSpendItem);
            }
            return topSpendResponseList;

        }catch(Exception e){
            log.error("Failed to fetch the top spend nodes");
            throw e;
        }

    }

    public List<TopSpendResponse> getTopSpendClusters() throws Exception{
        try{

            List<TopSpendEntity> kList=this.topSpendRepository.getTopSpendClusters();
            List<TopSpendResponse> topSpendResponseList=new ArrayList<>();
            for(TopSpendEntity kItem:kList){

                TopSpendResponse topSpendItem=new TopSpendResponse();
                topSpendItem.setStorageCost(kItem.getStorageCost());
                topSpendItem.setMemoryCost(kItem.getMemoryCost());
                topSpendItem.setCpuCost(kItem.getCpuCost());

                topSpendResponseList.add(topSpendItem);
            }
            return topSpendResponseList;

        }catch(Exception e){
            log.error("Failed to fetch the top spend nodes");
            throw e;
        }

    }
}
