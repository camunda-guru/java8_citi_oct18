package com.citi.banking.models;

import java.time.LocalDate;

public class Product {

	private int productId;
	private String name;
	private LocalDate dop;
	
	public Product(int productId, String name, LocalDate dop) {
		super();
		this.productId = productId;
		this.name = name;
		this.dop = dop;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDop() {
		return dop;
	}
	public void setDop(LocalDate dop) {
		this.dop = dop;
	}
	
	
}
