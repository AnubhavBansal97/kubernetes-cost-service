package com.hackathon.kubernetescostservice.controllers;

import com.hackathon.kubernetescostservice.dao.KubeDaoImpl;
import com.hackathon.kubernetescostservice.entity.KubeSummaryResponse;
import com.hackathon.kubernetescostservice.entity.TopSpendResponse;
import com.hackathon.kubernetescostservice.service.KubeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "/kube")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ExternalController {

    private final KubeService kubeService;

    @GetMapping("/summary")
    public ResponseEntity<KubeSummaryResponse>  getDashboardSummary() throws Exception{
        try{
            KubeSummaryResponse response=this.kubeService.getSummary();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);

        }catch(Exception e){
            throw e;
        }
    }

    @GetMapping("/topSpend/nodes")
    public ResponseEntity<List<TopSpendResponse>>  getTopSpendNodes() throws Exception{
        try{
            List<TopSpendResponse> response=this.kubeService.getTopSpendNodes();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);

        }catch(Exception e){
            throw e;
        }
    }

    @GetMapping("/topSpend/clusters")
    public ResponseEntity<List<TopSpendResponse>>  getTopSpendClusters() throws Exception{
        try{
            List<TopSpendResponse> response=this.kubeService.getTopSpendClusters();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);

        }catch(Exception e){
            throw e;
        }
    }



}
