package com.product.service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductRequest {

	@NotBlank(message = "Product name is required")
	private String productName;

	@NotNull(message = "Quantity is required")
	@Min(value = 1, message = "Quantity should be greater than 0")
	private Integer quantity;

	@NotNull(message = "Price is required")
	@Min(value = 1, message = "Price should be greater than 0")
	private Double price;

	@NotBlank(message = "Description is required")
	private String description;

	public ProductRequest() {
	}

	public ProductRequest(String productName, Integer quantity, Double price, String description) {
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
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