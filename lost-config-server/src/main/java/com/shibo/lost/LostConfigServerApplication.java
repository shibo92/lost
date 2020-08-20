package com.shibo.lost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LostConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LostConfigServerApplication.class, args);
    }

}
