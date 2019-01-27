package com.sid.daoImpl;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sid.dao.SignUpDao;
import com.sid.dto.UserDetailsClient;
import com.sid.model.UserDetails;
import com.sid.model.UserSecurity;

@Repository
@Transactional
public class SignUpDaoImpl implements SignUpDao {
	
	public void test(){
		UserDetails us = new UserDetails();
		us.setUserName("Test");
		us.setUserEmail("Test");
		us.setUserReferenceId("Test");
		getSession().save(us);
	}
	

	public String referenceIdGenerator(String name) {
		// generate a 4 digit integer 1000 <10000
		int randomPIN = (int) (Math.random() * 9000) + 1000;

		// Store integer in a string
		String PINString = String.valueOf(randomPIN);
		return name + PINString;

	}

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public String checkEmail(String email) {
		String userName = getSession().createQuery("SELECT userName FROM UserDetails where userEmail = ?")
				.setParameter(0, email).list().toString();
		if (userName.equals("[]")) {
			return "Not present";
		}
		return "Present";
	}

	@Override
	public String add(UserDetailsClient userDetailsClient) {
		// TODO Auto-generated method stub
		test();
		String emailCheck = checkEmail(userDetailsClient.getUserEmail());
		if (emailCheck.equals("Not present")) {
			String referenceId = referenceIdGenerator(userDetailsClient.getUserName());
			System.out.println(userDetailsClient.getUserName());
			System.out.println(userDetailsClient.getUserEmail());
			System.out.println(userDetailsClient.getUserPassword());
			UserDetails userDetail = new UserDetails();
			userDetail.setUserName(userDetailsClient.getUserName());
			userDetail.setUserEmail(userDetailsClient.getUserEmail());
			userDetail.setUserReferenceId(referenceId);

			UserSecurity userSecurity = new UserSecurity();
			System.out.println(userDetailsClient.getUserPassword());
			userSecurity.setPassword(userDetailsClient.getUserPassword());
			
			userSecurity.setUser(userDetail);

			getSession().save(userDetail);
			getSession().save(userSecurity);

			return "Added";
		}

		return "Email Already Present";
	}

}
