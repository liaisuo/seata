package com.example.seataorderdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.example.seataorderdemo.dao")
@EnableFeignClients
public class SeataOrderDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderDemoApplication.class, args);
    }

}
