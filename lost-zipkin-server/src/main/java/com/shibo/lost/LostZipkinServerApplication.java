package com.shibo.lost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Enable
public class LostZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LostZipkinServerApplication.class, args);
    }

}
