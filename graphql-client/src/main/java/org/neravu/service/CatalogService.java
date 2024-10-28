package org.neravu.service;

import java.util.List;

import org.neravu.client.InventoryClient;
import org.neravu.dto.Item;
import org.neravu.dto.ItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogService {
	
	@Autowired
	private InventoryClient inventoryClient;
	
	public List<Item> viewProducts() {
		return inventoryClient.viewProducts();
	}

	public List<Item> getProductsByCategory(String category) {
		return inventoryClient.getProductsByCategory(category);
	}

	public Item updateStock(ItemRequest input) {
		return inventoryClient.updateStock(input);
	}
}
