package com.learning.RestaurantListing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

@EnableDiscoveryClient
@Configuration
@SpringBootApplication
public class RestaurantListingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantListingServiceApplication.class, args);
	}

}
	