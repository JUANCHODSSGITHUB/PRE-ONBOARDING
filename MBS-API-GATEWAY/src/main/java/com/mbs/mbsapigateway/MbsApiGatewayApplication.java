package com.mbs.mbsapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MbsApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MbsApiGatewayApplication.class, args);
    }

}
