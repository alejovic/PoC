package org.example.sample.microservices.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // not required for Eureka, but it is required for other discovery services
public class MicroserviceRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceRegistrationApplication.class, args);
	}

}
