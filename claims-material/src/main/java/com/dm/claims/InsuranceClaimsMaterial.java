package com.dm.claims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Create By WeiBin on 2020/7/15 14:35
 */
@SpringBootApplication
@EnableDiscoveryClient
public class InsuranceClaimsMaterial {
    public static void main(String[] args) {
        SpringApplication.run(InsuranceClaimsMaterial.class,args);
    }
}
