package com.sid.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.dao.SignUpDao;
import com.sid.dto.UserDetailsClient;
import com.sid.service.SignUpService;
@Service
public class SignUpServiceImpl implements SignUpService {
	@Autowired
	private SignUpDao signUpDao;

	@Override
	public String add(UserDetailsClient userDetailsClient) {
		return signUpDao.add(userDetailsClient);
	}

}
