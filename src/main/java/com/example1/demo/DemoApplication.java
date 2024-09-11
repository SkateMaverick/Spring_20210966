package com.example1.demo; //현재 폴더 위치

import org.springframework.boot.SpringApplication; //스프링 핵심 클래스
import org.springframework.boot.autoconfigure.SpringBootApplication;//자동 설정 기능 활성화



@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
