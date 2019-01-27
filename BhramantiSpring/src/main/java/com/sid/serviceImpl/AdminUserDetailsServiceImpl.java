package com.sid.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.dao.AdminUserDetailsDao;
import com.sid.service.AdminUserDetailsService;
@Service
public class AdminUserDetailsServiceImpl implements AdminUserDetailsService {
	
	@Autowired
	private AdminUserDetailsDao adminUserDetailsDao;
	
	@Override
	public int totalMembers() {
		
		return adminUserDetailsDao.totalMembers();
	}

	@Override
	public ArrayList<String> nameOfUsers() {
		// TODO Auto-generated method stub
		return adminUserDetailsDao.nameOfUsers();
	}

}
