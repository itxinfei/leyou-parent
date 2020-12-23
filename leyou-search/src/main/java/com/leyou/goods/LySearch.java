package com.leyou.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 搜索服务
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication//(exclude = DataSourceAutoConfiguration.class)
public class LySearch {
    public static void main(String[] args) {
        SpringApplication.run(LySearch.class, args);
    }
}
