package com.cgg.task2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgg.task2.bo.CompanyBO;
import com.cgg.task2.mapper.CompanyMapper;
import com.cgg.task2.vo.ProductVo;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired 
	private CompanyBO companyBO;
	@Override
	public List<ProductVo> getProductByRestTemp() {
		
		return companyMapper.dtoToEntity(companyBO.getProductByRestTemp());
	//	return companyBO.getProductByRestTemp();
	}

	@Override
	public List<ProductVo> getProductByFeignClient() {

		return companyMapper.dtoToEntity(companyBO.getProductByFeignClient());
	}

}
