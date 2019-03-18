package com.sid.daoImpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sid.dao.LinkUserPackageDao;
import com.sid.dto.UserPackageLink;
import com.sid.model.HolidayPackageModel;
import com.sid.model.UserDetails;
@Repository
@Transactional
public class LinkUserPackageDaoImpl implements LinkUserPackageDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public String linkUserPackage(UserPackageLink userPackageLink) {
		
		ArrayList<UserDetails> user = (ArrayList<UserDetails>) getSession().createQuery("FROM UserDetails WHERE userEmail = ?").setParameter(0, userPackageLink.getUserEmail()).list();
		System.out.println(user.get(0).getUserEmail());
		ArrayList<HolidayPackageModel> pkge = (ArrayList<HolidayPackageModel>) getSession().createQuery("FROM HolidayPackageModel WHERE packageName = ?").setParameter(0, userPackageLink.getPackageName()).list();
		UserDetails usr = user.get(0);
		HolidayPackageModel pkg = pkge.get(0);
		
		usr.getPackages().add(pkg);
		pkg.getUsers().add(usr);
		
		getSession().update(usr);
		getSession().update(pkg);
		
		return "Linked Sucessfully!";
	}

}
