package com.example.microservices.api_gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("currency-exchange-service", r -> r
                        .path("/currency-exchange/**")
                        .uri("lb://currency-exchange-service"))
                .route("currency-conversion-service", r -> r
                        .path("/currency-conversion/**")
                        .uri("lb://currency-conversion-service"))
                .route("currency-conversion-service", r -> r
                        .path("/currency-conversion-new/**")
                        .filters(f -> f.rewritePath("/currency-conversion-new/", "/currency-conversion/"))
                        .uri("lb://currency-conversion-service"))
                .build();
    }
}

