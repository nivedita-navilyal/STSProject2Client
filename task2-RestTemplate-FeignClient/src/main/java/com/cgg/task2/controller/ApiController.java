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

import com.cgg.task2.config.Task2Config;
import com.cgg.task2.dto.ProductDto;
import com.cgg.task2.service.CompanyService;
import com.cgg.task2.serviceproxy.gradleTask1ServiceProxy;
import com.cgg.task2.vo.ProductVo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("company")
public class ApiController {
	
	private static final String COMPANY_SERVICE_FEIGN_CLIENT = "companyServiceFeignClient";

	private static final String SERVICE_REST_TEMPLATE = "serviceRestTemplate";

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired 
	private CompanyService companyService;
	
	Logger logger = LoggerFactory.getLogger(ApiController.class);
	
	@Autowired
	private Task2Config task2Config;
	
	
	@GetMapping("/restTemplate")
	@CircuitBreaker(name=SERVICE_REST_TEMPLATE,fallbackMethod="getFallBackRestTemplate")
	public ResponseEntity<List<ProductVo>> getProductByRestTemp(){
		List<ProductVo> list= companyService.getProductByRestTemp();
		return new ResponseEntity<List<ProductVo>>(list,HttpStatus.OK);
		
	}
	public ResponseEntity<String> getFallBackRestTemplate(Exception e){
		return new ResponseEntity<String>("Product service is down!!Rest Template",HttpStatus.OK);
	}
	
	
	@GetMapping("/feignClient/getproducts/usingcompany")
	@CircuitBreaker(name=COMPANY_SERVICE_FEIGN_CLIENT , fallbackMethod="getFallBackFeignclient")
	public ResponseEntity<List<ProductVo>> getProductByFeignClient(){
		
		List<ProductVo> feignList= companyService.getProductByFeignClient();
		return new ResponseEntity<List<ProductVo>>(feignList,HttpStatus.OK);
		
	}
	
	public ResponseEntity<String> getFallBackFeignclient(Exception e){
		return new ResponseEntity<String>("Currently service is down",HttpStatus.OK);
	}

}


//@GetMapping("/restTemplate")
//public List<ProductDto> getProduts(){
//	logger.info("using rest template");
//	List<ProductDto> products =Arrays.asList(restTemplate.getForObject(task2Config.getResturl(), ProductDto.class));
//	return products;
//	
//	
//}
//
//@GetMapping("/feignClient/getproducts/usingcompany")
//public List<ProductDto> getProducts(){
//	logger.info("using feign Client");
//	return serviceProxy.getProductByFeignClient();
//	
//		
//}




