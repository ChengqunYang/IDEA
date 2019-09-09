package com.monster.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//声明该类是一个SpringBoot引导类
@SpringBootApplication
public class Application {

	//main是Java程序的入口
	public static void main(String[] args) {
		//启动了springboot程序,启动了spring容器,启动内嵌的tomcat
		SpringApplication.run(Application.class, args);
	}

}
