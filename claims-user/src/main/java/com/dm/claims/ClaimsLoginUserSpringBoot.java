package com.dm.claims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Create By WeiBin on 2020/7/26 14:41
 * @author WB
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ClaimsLoginUserSpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(ClaimsLoginUserSpringBoot.class,args);
    }
}
