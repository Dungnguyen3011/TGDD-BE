package com.project.tgdd_be.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminAPI {
	
	@GetMapping("/api/admin")
	public String admin() {
		return "https://react-tgdd.vercel.app/admin";
	}

	@GetMapping("/api/home")
	public String home() {
		return "https://react-tgdd.vercel.app/";
	}
}
