package com.blue.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.blue"})
//@ComponentScan(basePackages={"com.blue.api.controller","com.blue.dao.entity","com.blue.dao.mapper"})
@MapperScan("com.blue.dao.mapper")
public class BlueApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlueApiApplication.class, args);
	}

}
