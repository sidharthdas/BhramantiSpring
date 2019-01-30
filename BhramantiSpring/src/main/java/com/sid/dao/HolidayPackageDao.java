package com.sid.dao;

import java.util.ArrayList;

import com.sid.dto.HolidayPackage;
import com.sid.model.HolidayPackageModel;

public interface HolidayPackageDao {
	
	public ArrayList<HolidayPackageModel> showAllPackages();
	public HolidayPackageModel showPackageByName(String packageName);
	public String addPackage(HolidayPackage holidayPackage);
	public HolidayPackageModel updatePackage(HolidayPackage holidayPackage);
	public String deletePackage(String packageName);

}
