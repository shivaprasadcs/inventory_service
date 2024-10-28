package org.neravu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GraphQLClientConfig {

	public HttpGraphQlClient graphQlClient() {
		WebClient webClient = WebClient
				.builder()
				.baseUrl("http://localhost:9090/graphql")
				.build();
		
		return HttpGraphQlClient.builder(webClient).build();

	}
}
