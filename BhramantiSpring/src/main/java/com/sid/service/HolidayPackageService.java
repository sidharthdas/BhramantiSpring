package com.sid.service;

import java.util.ArrayList;

import com.sid.dto.HolidayPackage;
import com.sid.model.HolidayPackageModel;

public interface HolidayPackageService {
	
	public ArrayList<HolidayPackageModel> showAllPackages();
	public HolidayPackageModel showPackageByName(String packageName);
	public String addPackage(HolidayPackage holidayPackage);
	public HolidayPackageModel updatePackage(HolidayPackage holidayPackage);
	public String deletePackage(String packageName);

}
