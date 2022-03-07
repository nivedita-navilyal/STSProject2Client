package com.cgg.task2.eo;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cgg.task2.config.Task2Config;
import com.cgg.task2.controller.ApiController;
import com.cgg.task2.dto.ProductDto;
import com.cgg.task2.serviceproxy.gradleTask1ServiceProxy;

@Component
@EnableFeignClients
public class ProductEOImpl implements ProductEO {

	@Autowired
	private Task2Config task2Config;
	
	@Autowired 
	private RestTemplate restTemplate;
	
	@Autowired 
	private gradleTask1ServiceProxy task1ServiceProxy;
	
	Logger logger = LoggerFactory.getLogger(ProductEO.class);
	
	//task2Config.getResturl()
	
	@Override
	public List<ProductDto> getProductByRestTemp() {
		logger.info("using rest template in EO layer");
		ProductDto[] products =restTemplate.getForObject("http://localhost:8080/product/api/getAllproducts", ProductDto[].class);
		return Arrays.asList(products);
	}

	@Override
	public List<ProductDto> getProductByFeignClient() {
		logger.info("using feign Client In Eo layer");
		return task1ServiceProxy.getProductsByFeign();
	}

}
