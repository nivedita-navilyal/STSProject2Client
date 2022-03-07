package com.cgg.task2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class Task2RestTemplateFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Task2RestTemplateFeignClientApplication.class, args);
	}
	
	@Autowired 
	public void setEnvVariable(Environment environment)
	{
		System.out.println(environment.getProperty("resturl"));
	}
	
	@Autowired 
	public void setEnvVarWiremock(Environment environment)
	{
		System.out.println(environment.getProperty("wmock_url"));
	}
	
	@Bean 
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
