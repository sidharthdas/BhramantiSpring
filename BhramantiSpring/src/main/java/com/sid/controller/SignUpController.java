package com.sid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sid.dto.UserDetailsClient;
import com.sid.service.SignUpService;

@RestController
public class SignUpController {
	@Autowired
	private SignUpService signUpService;
	
	@RequestMapping(value="/signuptest", method = RequestMethod.GET)
	public String test(){
		return "Working";
	}
	
	@RequestMapping(value="/addUser", method= RequestMethod.POST)
	public ResponseEntity<String> addUser(@RequestBody UserDetailsClient userDetailsClient){
		return new ResponseEntity<String>(signUpService.add(userDetailsClient), HttpStatus.CREATED);
	}

}
