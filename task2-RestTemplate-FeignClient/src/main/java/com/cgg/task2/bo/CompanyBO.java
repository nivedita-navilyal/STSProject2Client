package com.cgg.task2.bo;

import java.util.List;

import com.cgg.task2.dto.ProductDto;

public interface CompanyBO {

	public List<ProductDto> getProductByRestTemp();
	public List<ProductDto> getProductByFeignClient();
}
