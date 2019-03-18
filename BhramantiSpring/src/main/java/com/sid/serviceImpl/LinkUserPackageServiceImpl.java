package com.sid.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.dao.LinkUserPackageDao;
import com.sid.dto.UserPackageLink;
import com.sid.service.LinkUserPackageService;

@Service
public class LinkUserPackageServiceImpl implements LinkUserPackageService {

	@Autowired
	private LinkUserPackageDao linkUserPackageDao;

	public String linkUserPackage(UserPackageLink userPackageLink) {
		return linkUserPackageDao.linkUserPackage(userPackageLink);
	}

}
