package com.haoqi.hqedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.haoqi.hqedu.mapper")
public class HqeduApplication {

	public static void main(String[] args) {
		SpringApplication.run(HqeduApplication.class, args);
	}

}
