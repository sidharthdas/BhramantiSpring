package com.sid.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.dao.HolidayPackageDao;
import com.sid.dto.HolidayPackage;
import com.sid.model.HolidayPackageModel;
import com.sid.service.HolidayPackageService;
@Service
public class HolidayPackageServiceImpl implements HolidayPackageService {
	
	@Autowired
	private HolidayPackageDao holidayPackageDao;
	
	
	@Override
	public ArrayList<HolidayPackageModel> showAllPackages() {
		// TODO Auto-generated method stub
		return holidayPackageDao.showAllPackages();
	}

	@Override
	public HolidayPackageModel showPackageByName(String packageName) {
		// TODO Auto-generated method stub
		return holidayPackageDao.showPackageByName(packageName);
	}

	@Override
	public String addPackage(HolidayPackage holidayPackage) {
		// TODO Auto-generated method stub
		return holidayPackageDao.addPackage(holidayPackage);
	}

	
	

	@Override
	public String deletePackage(String packageName) {
		// TODO Auto-generated method stub
		return holidayPackageDao.deletePackage(packageName);
	}

	@Override
	public HolidayPackageModel updatePackage(HolidayPackage holidayPackage) {
		// TODO Auto-generated method stub
		return holidayPackageDao.updatePackage(holidayPackage);
	}

}
