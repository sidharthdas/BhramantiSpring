package com.sid.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sid.dto.HolidayPackage;
import com.sid.model.HolidayPackageModel;
import com.sid.service.HolidayPackageService;

@RestController 
public class HolidayPackageController {
	
	@Autowired
	private HolidayPackageService holidayPackageService;
	
	
	@RequestMapping(value="/testHolidayPackageController", method = RequestMethod.GET)
	public String test(){
		return "HolidayPackage Controller is working";
	}
	
	@RequestMapping(value= "/addPackage", method = RequestMethod.POST)
	public ResponseEntity<String> addPackage(@RequestBody HolidayPackage holidayPackage){
		return new ResponseEntity<String>(holidayPackageService.addPackage(holidayPackage), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/PackageByName", method = RequestMethod.POST)
	public ResponseEntity<HolidayPackageModel> showPackageByName(@RequestBody String packageName){
		return new ResponseEntity<HolidayPackageModel>(holidayPackageService.showPackageByName(packageName), HttpStatus.CREATED);
	}
	
	@RequestMapping(value= "/showAllPackages", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<HolidayPackageModel>> showAllPackages(){
		return new ResponseEntity<ArrayList<HolidayPackageModel>>(holidayPackageService.showAllPackages(), HttpStatus.FOUND);
	}
	
	@RequestMapping(value = "/deleteApackage", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletePackage(@RequestBody String packageName){
		return new ResponseEntity<String>(holidayPackageService.deletePackage(packageName), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/updatePackage", method = RequestMethod.PUT)
	public ResponseEntity<HolidayPackageModel> updatePackage(@RequestBody HolidayPackage holidayPackage){
		return new ResponseEntity<HolidayPackageModel>(holidayPackageService.updatePackage(holidayPackage), HttpStatus.ACCEPTED);
	}

}
