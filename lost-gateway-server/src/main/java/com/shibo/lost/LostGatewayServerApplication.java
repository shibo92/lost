package com.shibo.lost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LostGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LostGatewayServerApplication.class, args);
	}

}
