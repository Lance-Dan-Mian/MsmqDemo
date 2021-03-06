package com.asl.msmqdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class MsmqdemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsmqdemoApplication.class, args);
    }
}
