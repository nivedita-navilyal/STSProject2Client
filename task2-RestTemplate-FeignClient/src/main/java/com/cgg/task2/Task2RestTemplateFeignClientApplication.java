package com.cgg.task2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class Task2RestTemplateFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Task2RestTemplateFeignClientApplication.class, args);
	}
	
	@Bean 
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
