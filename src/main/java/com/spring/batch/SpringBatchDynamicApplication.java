package com.spring.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
public class SpringBatchDynamicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchDynamicApplication.class, args);
    }

}
