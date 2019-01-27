package com.sid.dao;

import com.sid.dto.LoginCredential;

public interface LoginDao {
	public String login(LoginCredential loginCredential);
}
