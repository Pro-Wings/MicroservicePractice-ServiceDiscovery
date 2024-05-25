package com.prowings.demo_retry_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;


@Service
public class RetryAppService {
	
	@Autowired
	RestTemplate restTemplate;

	String url = "http://localhost:8082/hello";
	
	@Retryable(maxAttempts = 4, backoff = @Backoff(delay = 5000))
	public String callHelloWorldGetHello() {
		ResponseEntity<String> response = null;

			System.out.println("making call to HelloWorldService!!!");
			response = restTemplate.getForEntity(url, String.class);
			return response.getBody();

	}
	
	 @Recover
	 public String recover(Exception e) {
		 
		 System.out.println(">>>>>>>>>>>>>>>>>>");
		 System.out.println("can not recover from exception : "+e.getClass().getName());
		 System.out.println(">>>>>>>>>>>>>>>>>>");
		 return "hhhhhhhhhh";
		 
	    }
}
