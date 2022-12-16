package com.mbs.mbcconversionmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MbcConversionMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MbcConversionMicroserviceApplication.class, args);
    }

}
