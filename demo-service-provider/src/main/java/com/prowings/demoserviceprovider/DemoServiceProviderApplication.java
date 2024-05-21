package com.prowings.demoserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaClient   -- commented this as we are using SpringBoot 3XX
public class DemoServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoServiceProviderApplication.class, args);
	}

}
