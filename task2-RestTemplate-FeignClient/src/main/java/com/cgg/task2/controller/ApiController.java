package com.cgg.task2.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cgg.task2.VO.ProductDto;
import com.cgg.task2.serviceproxy.gradleTask1ServiceProxy;

@RestController
@RequestMapping("company")
public class ApiController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired 
	private gradleTask1ServiceProxy serviceProxy;
	
	Logger logger = LoggerFactory.getLogger(ApiController.class);
	
	private static String url= "http://localhost:8080/product/api/getAllproducts";
	
	@GetMapping("/restTemplate")
	public List<ProductDto> getProduts(){
		logger.info("using rest template");
		ProductDto[] products =restTemplate.getForObject(url, ProductDto[].class);
		return Arrays.asList(products);
		
		
	}
	
	@GetMapping("/feignClient/getproducts/usingcompany")
	public ResponseEntity<List<ProductDto>> getProducts(){
		logger.info("using feign Client");
		return serviceProxy.getProducts();
		
			
	}

}
