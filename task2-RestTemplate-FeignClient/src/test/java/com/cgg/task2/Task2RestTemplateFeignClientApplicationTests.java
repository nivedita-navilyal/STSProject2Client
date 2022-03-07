package com.cgg.task2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.cgg.task2.dto.ProductDto;
import com.cgg.task2.serviceproxy.gradleTask1ServiceProxy;

@SpringBootTest
@AutoConfigureMockMvc
class Task2RestTemplateFeignClientApplicationTests {

	@MockBean
	RestTemplate restTemplate;
	
	@Mock
	private gradleTask1ServiceProxy proxyService;
	
	@Autowired
	private MockMvc mockMvc;
	

	// =========================================== Get All Products using Rest Template ==========================================

		@Test
		public void findAllProducts() throws Exception{
			ProductDto[] pro = new ProductDto[2];
			pro[0]=new ProductDto(1, "redmi", "8gb", 9000, 3, "my company");
			pro[1]=new ProductDto(1, "redmi", "8gb", 9000, 3, "my company");
			
			Mockito.when(restTemplate.getForObject("http://localhost:8080/product/api/getAllproducts", ProductDto[].class)).thenReturn(pro);
			mockMvc.perform(get("/company/restTemplate")).andExpect(status().isOk());
			assertEquals(pro.length, 2);
			
		
		}
		
		// =========================================== Get All Products using Feign Client ==========================================
		@Test
		public void findAllProducts_usingFeignClient() throws Exception{

			List<ProductDto> productDtos = new ArrayList<ProductDto>();
			ProductDto productDto1 = new ProductDto(1, "redmi", "8gb", 9000, 3, "my company");
			ProductDto productDto2 = new ProductDto(2, "cool", "4gb", 8000, 7, "my company");
			ProductDto productDto3 = new ProductDto(3, "jio", "6gb", 5000, 3, "my company");
			ProductDto productDto4 = new ProductDto(4, "samsung", "8gb", 12000, 4, "my company");
			productDtos.add(productDto1);
			productDtos.add(productDto2);
			productDtos.add(productDto3);
			productDtos.add(productDto4);
			
			Mockito.when(proxyService.getProductsByFeign())
						.thenReturn(productDtos);
			mockMvc.perform(get("/company/feignClient/getproducts/usingcompany"))
				.andExpect(status().isOk());
			assertEquals(productDtos.size(),4);
			
			
		}
	
	
	

}




//ProductDto[] pro = new ProductDto[2];
//pro[0]=new ProductDto(1, "redmi", "8gb", 9000, 3, "my company");
//pro[1]=new ProductDto(1, "redmi", "8gb", 9000, 3, "my company");
//
//Mockito.when(proxyService.("http://localhost:8080/product/api/getAllproducts", ProductDto[].class)).thenReturn(pro);
//mockMvc.perform(get("/company/feignClient/getproducts/usingcompany")).andExpect(status().isOk());
//assertEquals(pro.length, 2);

//ProductDto pro = new ProductDto(1, "redmi", "8gb", 9000, 3, "my company");
//assertThat(this.proxyService.getProducts()).isEqualTo(pro);

