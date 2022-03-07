package com.cgg.task2.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
public class ProductVo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Pattern(regexp = "^[A-Za-z]+$", message = "Product name should be in alphabates only.")
	private String name;
	private String description;
    @Min(1)
	private int quantity;
    @Min(100)
	private long price;
    
    private String company;
    
    public ProductVo() {
    	
    }

	public ProductVo(int id,
			@Pattern(regexp = "^[A-Za-z]+$", message = "Product name should be in alphabates only.") String name,
			String description, @Min(1) int quantity, @Min(100) long price, String company) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

    
}
