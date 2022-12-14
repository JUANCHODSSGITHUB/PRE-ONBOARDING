package com.mbs.mbsapigateway.config;

import com.mbs.mbsapigateway.filter.JwtAuthenticationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {


    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder, JwtAuthenticationFilter filter) {

        return builder.routes()
                .route("user", r -> r.path("/user/**").filters(f -> f.filter(filter)).uri("lb://USER-SERVICE"))
                .route("account", r -> r.path("/account/**").filters(f -> f.filter(filter)).uri("lb://ACCOUNT-SERVICE"))
                .route("auth", r -> r.path("/auth/**").filters(f -> f.filter(filter)).uri("lb://AUTH-SERVICE"))
                .route("conversion", r -> r.path("/conversion/**").filters(f -> f.filter(filter)).uri("lb://CONVERSION-SERVICE"))
                .route("transaction", r -> r.path("/transaction/**").filters(f -> f.filter(filter)).uri("lb://CONVERSION-SERVICE"))
                .build();
    }
}
