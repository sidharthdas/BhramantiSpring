package com.sid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sid.dto.UserPackageLink;
import com.sid.service.LinkUserPackageService;

@RestController
public class LinkUserPackage {
	
	@Autowired
	private LinkUserPackageService linkUserPackageService; 
	
	@RequestMapping(value = "/testLinkUserPackage", method = RequestMethod.GET)
	public String testLinkUserPackage() {
		return "Working";
	}
	@RequestMapping(value = "/link", method = RequestMethod.POST)
	public ResponseEntity<String> linkUserPackage(@RequestBody UserPackageLink userPackageLink){
		return new ResponseEntity<String>(linkUserPackageService.linkUserPackage(userPackageLink), HttpStatus.ACCEPTED);
	}

}
