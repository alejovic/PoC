package org.example.sample.microservices.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // not required for Eureka, but it is required for other discovery services
public class MicroserviceCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCatalogApplication.class, args);
	}

}
