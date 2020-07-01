package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 乐优商城API网关
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ApiGateway {
    public static void main(String[] args) {
        SpringApplication.run(ApiGateway.class, args);
    }
}