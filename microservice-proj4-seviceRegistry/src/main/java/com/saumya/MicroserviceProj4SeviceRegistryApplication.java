package com.saumya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceProj4SeviceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProj4SeviceRegistryApplication.class, args);
	}

}
