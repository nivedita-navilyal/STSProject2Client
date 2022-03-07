package com.cgg.task2.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cgg.task2.dto.ProductDto;
import com.cgg.task2.vo.ProductVo;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
	
	CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);
	List<ProductVo> dtoToEntity(List<ProductDto> ProductDto);

}
