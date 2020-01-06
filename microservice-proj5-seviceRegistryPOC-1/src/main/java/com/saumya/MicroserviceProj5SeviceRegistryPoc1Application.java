package com.saumya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceProj5SeviceRegistryPoc1Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProj5SeviceRegistryPoc1Application.class, args);
	}

}
