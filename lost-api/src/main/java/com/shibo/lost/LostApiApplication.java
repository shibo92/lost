package com.shibo.lost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LostApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LostApiApplication.class, args);
    }

}
