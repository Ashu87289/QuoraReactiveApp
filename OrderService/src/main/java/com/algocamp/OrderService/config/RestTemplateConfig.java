package com.algocamp.OrderService.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
/*Adding Load balancer on a RestTemplate enables client-side load balancing.
* It intercept the local servicenames and resolve them into actual instances URL's from Eureka.*/