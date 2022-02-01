package com.hackathon.kubernetescostservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KubernetesCostServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KubernetesCostServiceApplication.class, args);
        System.out.println("Working");
    }

}
