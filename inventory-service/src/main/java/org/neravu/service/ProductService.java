package org.neravu.service;

import java.util.List;

import org.neravu.entity.Product;
import org.neravu.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
   
	public List<Product> listAllProducts(){
		return productRepository.findAll();
	}
	
	public List<Product> getProductsByCategory(String category){
		return productRepository.findByCategory(category);
	}
}
