package com.prowings.demoserviceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemoServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoServiceConsumerApplication.class, args);
	}

}
