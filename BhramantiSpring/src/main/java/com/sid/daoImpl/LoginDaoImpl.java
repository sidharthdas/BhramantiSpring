package com.sid.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sid.dao.LoginDao;
import com.sid.dto.LoginCredential;


@Repository
@Transactional
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public String login(LoginCredential loginCredential) {
		// TODO Auto-generated method stub
		String userName = getSession().createQuery("SELECT userName from UserDetails WHERE userEmail = ?").setParameter(0,loginCredential.getUserEmail() ).list().toString();
		System.out.println(userName);
		if(userName.equals("[]")){
			return "Email doesn't exist";
		}
		else{
			String passwordFromDB = getSession().createSQLQuery("select s.password from userdetails d inner join usersecurity s where d.userId = s.user_userId and d.userEmail = ?").setParameter(0, loginCredential.getUserEmail()).list().toString();
			//String passwordFromDB= getSession().createQuery("SELECT s.password from UserDetails d INNER JOIN UserSecurity s where d.userId = s.user_userId and d.userEmail = ?").setParameter(0,loginCredential.getUserEmail() ).list().toString();
			String pswdDB = passwordFromDB.substring(1, passwordFromDB.length()-1);
			System.out.println("Passowrd from DB: "+pswdDB);
			System.out.println("Password from client is: "+loginCredential.getPassword());
			if(pswdDB.equals(loginCredential.getPassword())){
				String numOfUsers = getSession().createSQLQuery("SELECT COUNT(*) FROM userdetails").list().toString();
				return "Login Sucessfull AND NUMBER OF USERS ARE "+numOfUsers;
			}
		}
		return "InCorrect Password";
	}

}
