package com.blue.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.blue.dao.mapper")
public class BlueDaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlueDaoApplication.class, args);
		System.out.println("blue-dao启动成功");
	}
}
