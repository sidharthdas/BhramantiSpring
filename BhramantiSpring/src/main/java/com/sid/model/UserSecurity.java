package com.sid.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "UserSecurity")
@Table(name = "UserSecurity")
public class UserSecurity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userSecurityId;
	private String password;
	@OneToOne
	private UserDetails user;

	public int getUserSecurityId() {
		return userSecurityId;
	}

	public void setUserSecurityId(int userSecurityId) {
		this.userSecurityId = userSecurityId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

}
