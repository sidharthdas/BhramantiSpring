package com.sid.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sid.service.AdminUserDetailsService;

@RestController(value = "/admin/")
public class AdminUserDetailsController {
	
	@Autowired
	private AdminUserDetailsService adminUserDetailsService;
	
	@RequestMapping(value = "/testAdmin", method = RequestMethod.GET)
	public String testAdmin(){
		return "admin controller is working . . .";
	}
	
	@RequestMapping(value= "/numberOfUsers", method = RequestMethod.POST)
	public ResponseEntity<Integer> numOfUsers(){
		return new ResponseEntity<Integer>(adminUserDetailsService.totalMembers(),HttpStatus.FOUND);
	}
	
	@RequestMapping(value= "/usersname", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<String>> userNames(){
		return new ResponseEntity<ArrayList<String>>(adminUserDetailsService.nameOfUsers(),HttpStatus.FOUND);
	}

}
