package com.product.service.dto;

public class ProductResponse {

	private Long id;
	private String productName;
	private Integer quantity;
	private Double price;
	private String description;

	public ProductResponse() {
	}

	public ProductResponse(Long id, String productName, Integer quantity, Double price, String description) {
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
