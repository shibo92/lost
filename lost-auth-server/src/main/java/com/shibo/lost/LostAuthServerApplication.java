package com.shibo.lost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LostAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LostAuthServerApplication.class, args);
    }

}
