package com.sid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sid.dto.LoginCredential;
import com.sid.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/loginTest", method = RequestMethod.GET)
	public String loginTest(){
		return "Login controller working";
	}
	
	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody LoginCredential loginCredential){
		return new ResponseEntity<String>(loginService.Login(loginCredential), HttpStatus.FOUND);
	}*/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody LoginCredential loginCredential){
		return loginService.Login(loginCredential);
	}
	
	

}
