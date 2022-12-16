package com.mbs.mbseurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MbsEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MbsEurekaServerApplication.class, args);
    }

}
