package com.sid.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.dao.LoginDao;
import com.sid.dto.LoginCredential;
import com.sid.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;

	@Override
	public String Login(LoginCredential loginCredential) {
		// TODO Auto-generated method stub
		return loginDao.login(loginCredential);
	}

}
