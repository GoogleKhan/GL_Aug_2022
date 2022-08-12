package com.wipro.springcloudconfigclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

	@Value("${my.message}")
	private String greet;

	@Value("${my.fruits}")
	private List<String> fruits;

	@GetMapping("/display")
	public String displayProperties() {

		System.out.println("my.greeting=" + greet);
		System.out.println("fruits=" + fruits);

		return "See your Console...";
	}

}
