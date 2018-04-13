package com.prasilius.services.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestService {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello!";
	}
}
