package com.cgg.task2.serviceproxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.cgg.task2.VO.ProductDto;

@FeignClient(name="gradle-task1-products", url="http://localhost:8080/")
public interface gradleTask1ServiceProxy {
	

	@GetMapping("product/api/getAllproducts")
	public ResponseEntity<List<ProductDto>> getProducts();
	

}
