package com.cgg.task2.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cgg.task2.dto.ProductDto;
import com.cgg.task2.eo.ProductEO;

@Component
public class CompanyBOimpl implements CompanyBO{

	@Autowired 
	private ProductEO productEo;
	@Override
	public List<ProductDto> getProductByRestTemp() {
		return productEo.getProductByRestTemp();
	}

	@Override
	public List<ProductDto> getProductByFeignClient() {
		return productEo.getProductByFeignClient();
	}

}
