package org.neravu.controller;

import java.util.List;

import org.neravu.dto.Item;
import org.neravu.dto.ItemRequest;
import org.neravu.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	private CatalogService catalogService;
	
	@GetMapping("/products")
	public List<Item> viewProducts() {
		return catalogService.viewProducts();
	}

	@GetMapping("/products/category")
	public List<Item> getProductsByCategory(String category) {
		return catalogService.getProductsByCategory(category);
	}
	@PostMapping("/products/stock/")
	public Item updateStock(@RequestBody ItemRequest input) {
		return catalogService.updateStock(input);
	}
}
