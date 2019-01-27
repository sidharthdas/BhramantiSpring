package com.sid.daoImpl;

import java.util.ArrayList;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sid.dao.AdminUserDetailsDao;
@Repository
@Transactional
public class AdminUserDetailsDaoImpl implements AdminUserDetailsDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public int totalMembers() {
		// TODO Auto-generated method stub
		String n = getSession().createSQLQuery("SELECT COUNT(*) FROM userdetails").list().toString();
		String numOfUsers = n.substring(1, n.length()-1);
		int totalUsers = Integer.parseInt(numOfUsers);
		return totalUsers;
	}

	@Override
	public ArrayList<String> nameOfUsers() {
		// TODO Auto-generated method stub
		ArrayList<String> userNames = new ArrayList<>();
		int totalUsers = totalMembers();
		
		for(int i = 1; i< totalUsers+1; i++){
			String n = getSession().createQuery("select userName from UserDetails where userId = ?").setParameter(0, i).list().toString();
			String userName = n.substring(1, n.length()-1);
			userNames.add(userName);
		}
		for(String s: userNames){
			System.out.println(s);
		}
		
		return userNames;
	}

}
