package com.example.ncov;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.ncov.dao")
@EnableScheduling
public class NcovApplication {
    public static void main(String[] args) {
        SpringApplication.run(NcovApplication.class, args);
    }

}
