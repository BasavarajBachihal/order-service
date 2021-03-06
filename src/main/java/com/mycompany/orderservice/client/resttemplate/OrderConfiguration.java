package com.mycompany.orderservice.client.resttemplate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class OrderConfiguration {

    @Value("${rest.call.connection.timeout:}")
    private Long connTimeout;
    @Value("${rest.call.read.timeout:}")
    private Long readTimeout;


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return  builder
                .setConnectTimeout(Duration.ofSeconds(connTimeout))
                .setReadTimeout(Duration.ofSeconds(readTimeout))
                .build();
    }
}