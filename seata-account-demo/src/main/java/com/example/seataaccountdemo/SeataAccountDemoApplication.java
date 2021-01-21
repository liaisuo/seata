package com.example.seataaccountdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.example.seataaccountdemo.dao")
public class SeataAccountDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountDemoApplication.class, args);
    }

}
