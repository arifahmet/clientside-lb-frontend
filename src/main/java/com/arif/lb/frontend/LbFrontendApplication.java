package com.arif.lb.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class LbFrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LbFrontendApplication.class, args);
    }

}
