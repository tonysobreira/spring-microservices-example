package com.project.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		
		return builder.routes()
				.route("demo-microservice", r -> r.path("/demo-microservice/**").uri("lb://demo-microservice"))
				.route("demo-microservice-open-feign",
						r -> r.path("/demo-microservice-open-feign/**").uri("lb://demo-microservice-open-feign"))
				.build();
	}

}