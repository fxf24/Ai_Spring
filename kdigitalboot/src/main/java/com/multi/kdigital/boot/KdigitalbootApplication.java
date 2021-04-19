package com.multi.kdigital.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KdigitalbootApplication {
//내장 tomcat 실행
	public static void main(String[] args) {
		SpringApplication.run(KdigitalbootApplication.class, args);
	}
//수동브라우저 열어서 http://127.0.0.1:9000/hello.boot - hello.jsp실행 결과
}
