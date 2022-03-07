package com.cgg.task2.eo;

import java.util.List;

import com.cgg.task2.dto.ProductDto;

public interface ProductEO {
	
	public List<ProductDto> getProductByRestTemp();
	public List<ProductDto> getProductByFeignClient();

}
