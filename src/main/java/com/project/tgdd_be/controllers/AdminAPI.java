package com.project.tgdd_be.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminAPI {
	
	
	@GetMapping("/api/admin")
	public void admin(HttpServletResponse res) throws IOException {
		res.sendRedirect("https://react-tgdd.vercel.app/admin");
	}

//	@GetMapping("/api/home")
//	public String home() {
//		URI uri = https://react-tgdd.vercel.app/admin;
//		return  Response.temporaryRedirect(uri).build();
//	}
}
