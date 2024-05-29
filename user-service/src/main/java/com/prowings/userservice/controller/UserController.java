package com.prowings.userservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Value("${pro.wings.name}")
	String orgName;

	@Value("${hello}")
	String appName;
	
	@GetMapping("/users")
	public String getUsers() {
		return "List of Users";
	}

	@GetMapping("/readConfig")
	public String readConfig() {
		return "user-service is running in ORG : "+orgName;
	}

	@GetMapping("/readConfigAppName")
	public String readConfigAppName() {
		return "Application name is : "+appName;
	}

}
