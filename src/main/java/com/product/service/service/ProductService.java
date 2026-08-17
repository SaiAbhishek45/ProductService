package com.product.service.service;

import org.springframework.stereotype.Service;

import com.product.service.dto.ProductRequest;
import com.product.service.dto.ProductResponse;
import com.product.service.entity.Product;
import com.product.service.exception.ProductNotFoundException;
import com.product.service.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public ProductResponse createProduct(ProductRequest request) {

		Product product = new Product();

		product.setProductName(request.getProductName());
		product.setQuantity(request.getQuantity());
		product.setPrice(request.getPrice());
		product.setDescription(request.getDescription());

		Product savedProduct = productRepository.save(product);

		return mapToResponse(savedProduct);

	}

	public List<ProductResponse> getAllProducts() {

		return productRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
	}

	public ProductResponse getProductById(Long productId) {

		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));

		return mapToResponse(product);
	}

	private ProductResponse mapToResponse(Product product) {

		ProductResponse response = new ProductResponse();

		response.setId(product.getId());
		response.setProductName(product.getProductName());
		response.setQuantity(product.getQuantity());
		response.setPrice(product.getPrice());
		response.setDescription(product.getDescription());

		return response;
	}
}