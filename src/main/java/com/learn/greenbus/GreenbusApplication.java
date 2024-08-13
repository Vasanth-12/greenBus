package com.learn.greenbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GreenbusApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GreenbusApplication.class, args);

	}

}
