package com.spriongboot.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.practice.Entity.LoginEntity;
import com.spriongboot.practice.service.LoginService;

@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginController {

	
	@Autowired
	LoginService loginService;
	
	
	@PostMapping(value = "signIn",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody LoginEntity login) {
		System.out.println("I cam here");
		return loginService.signIn(login);
		
	}
	
	@PostMapping(value = "signUp",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signUp(@RequestBody LoginEntity login) {
		System.out.println(login);
		return loginService.signUp(login);
	}
}


