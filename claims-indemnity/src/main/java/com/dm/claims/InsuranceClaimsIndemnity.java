package com.dm.claims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Create By WeiBin on 2020/7/15 14:34
 */
@SpringBootApplication
@EnableDiscoveryClient
public class InsuranceClaimsIndemnity {
    public static void main(String[] args) {
        SpringApplication.run(InsuranceClaimsIndemnity.class,args);
    }
}
