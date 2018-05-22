package com.blue.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.blue"})
@MapperScan("com.blue.dao.mapper")
public class BlueWebNameApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlueWebNameApplication.class, args);
    }

}
