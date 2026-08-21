package com.product.service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.product.service.dto.ProductRequest;
import com.product.service.dto.ProductResponse;
import com.product.service.service.ProductService;

@RestController
@RequestMapping("product-service/v1/products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductResponse createProduct(ProductRequest request) {
		return productService.createProduct(request);
	}

	@GetMapping
	public List<ProductResponse> getAllProducts() {
		return productService.getAllProducts();

	}

	@GetMapping("/{prodId}")
	public ProductResponse getProductById(@PathVariable Long prodId) {
		return productService.getProductById(prodId);
	}

}
