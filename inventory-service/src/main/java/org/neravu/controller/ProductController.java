package org.neravu.controller;

import java.util.List;

import org.neravu.entity.Product;
import org.neravu.repository.ProductRepository;
import org.neravu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;

	@QueryMapping
	public List<Product> listAllProducts() {
		return productService.listAllProducts();
	}

	@QueryMapping
	public List<Product> getProductsByCategory(@Argument String category) {
		return productService.getProductsByCategory(category);
	}

	@MutationMapping
	public Product updateStock(@Argument Long id, @Argument Integer stock) {
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product Not found with Id"));
		existingProduct.setStock(stock);
		return productRepository.save(existingProduct);
	}

}
