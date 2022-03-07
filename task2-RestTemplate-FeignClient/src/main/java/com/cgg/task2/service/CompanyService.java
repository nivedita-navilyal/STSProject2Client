package com.cgg.task2.service;

import java.util.List;

import com.cgg.task2.dto.ProductDto;
import com.cgg.task2.vo.ProductVo;

public interface CompanyService {
	public List<ProductVo> getProductByRestTemp();
	public List<ProductVo> getProductByFeignClient();

}
