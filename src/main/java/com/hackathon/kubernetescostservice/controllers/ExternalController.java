package com.hackathon.kubernetescostservice.controllers;

import com.hackathon.kubernetescostservice.entity.KubeSummaryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/kube")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ExternalController {

//    @GetMapping("/summary")
//    public ResponseEntity<KubeSummaryResponse> getDashboardSummary(){
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(KubeService);
//    }

}
