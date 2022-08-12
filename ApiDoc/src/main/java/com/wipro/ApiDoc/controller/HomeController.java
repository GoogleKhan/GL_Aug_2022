package com.wipro.ApiDoc.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "http://localhost:4200")
public class HomeController {

	@PostMapping("/insert")
	public String addName(String name) {
		return name + " is added";
	}
	

	@GetMapping("/get")
	public String getName() {
		return "Papa";
	}

}
