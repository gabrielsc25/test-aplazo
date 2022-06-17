package com.test.aplazo.gsc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.test.aplazo.gsc.*")
@SpringBootApplication
public class GscApplication {

	public static void main(String[] args) {
		SpringApplication.run(GscApplication.class, args);
	}


}
