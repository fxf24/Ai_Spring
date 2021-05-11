package com.multi.myboot01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import naver.cloud.NaverController;
import spring_mybatis.EmpController;
import spring_mybatis.EmpDAO;

@SpringBootApplication
@ComponentScan//생략가능(basePackageClasses = Myboot01Application.class)
@ComponentScan(basePackageClasses = EmpController.class)//empcontroller가 있는 패키지 스캔하겠다
@ComponentScan(basePackageClasses = NaverController.class)
@MapperScan(basePackageClasses = EmpDAO.class)
//servlet-context.xml - <context:component-scan base-packages="@Controller..클래스의 패키지명"/>
//servlet-context.xml - <context:component-scan base-packages="spring_mybatis"/>
public class Myboot01Application {

	public static void main(String[] args) {
		//spring boot tomcat 내장 서버 자동 실행
		SpringApplication.run(Myboot01Application.class, args);
		
	}

}
