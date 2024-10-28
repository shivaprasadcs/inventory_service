package org.neravu.client;

import java.util.List;

import org.neravu.dto.Item;
import org.neravu.dto.ItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class InventoryClient {

	@Autowired
	private HttpGraphQlClient graphQlClient;

	public List<Item> viewProducts() {

		String graphQLQuery = "query ListAllProducts {\r\n" + "    listAllProducts {\r\n" + "        price\r\n"
				+ "        name\r\n" + "    }\r\n" + "}";
		Mono<List<Item>> products = graphQlClient.document(graphQLQuery).retrieve(graphQLQuery)
				.toEntityList(Item.class);
		return products.block();
	}

	public List<Item> getProductsByCategory(String category) {

		String graphQLQuery = "query GetProductsByCategory {\r\n" + "    getProductsByCategory(category:\"%s\") {\r\n"
				+ "        id\r\n" + "        name\r\n" + "        decsription\r\n" + "        stock\r\n"
				+ "        price\r\n" + "        category\r\n" + "    }\r\n" + "}";

		Mono<List<Item>> products = graphQlClient.document(graphQLQuery).retrieve(graphQLQuery)
				.toEntityList(Item.class);
		return products.block();
	}

	public Item updateStock(ItemRequest input) {

		String graphQLQuery = String
				.format("mutation UpdateStock {\r\n" + "    updateStock(id: \"%s\", stock: %d) {\r\n" + "        id\r\n"
						+ "        name\r\n" + "        decsription\r\n" + "        stock\r\n" + "        price\r\n"
						+ "        category\r\n" + "    }\r\n" + "}", input.getId(), input.getStock());

		return graphQlClient.document(graphQLQuery).retrieve(graphQLQuery).toEntity(Item.class).block();
	}
}
