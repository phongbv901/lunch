package com.phongbv.lunch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.phongbv.lunch.endpoint"})
public class LunchApplication {

	public static void main(String[] args) {
		SpringApplication.run(LunchApplication.class, args);
	}

}
