package com.shibo.lost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LostEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LostEurekaServerApplication.class, args);
    }

}
