package com.sid.daoImpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sid.dao.HolidayPackageDao;
import com.sid.dto.HolidayPackage;
import com.sid.model.HolidayPackageModel;

@Repository
@Transactional
public class HolidayPackageDaoImpl implements HolidayPackageDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	private double discountCalculation(double amount, double discountPercent) {
		double discountPrice = amount - (amount * (discountPercent / 100));
		return discountPrice;
	}

	private Boolean check(double price, double discountPercent) {
		if (price > 0 && discountPercent > 0 && discountPercent < 99) {
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<HolidayPackageModel> showAllPackages() {
		ArrayList<HolidayPackageModel> holidayPackageModel = (ArrayList<HolidayPackageModel>) getSession()
				.createQuery("FROM HolidayPackageModel").list();
		return holidayPackageModel;
	}

	@Override
	public HolidayPackageModel showPackageByName(String packageName) {

		System.out.println("Package name = " + packageName);

		ArrayList<HolidayPackageModel> holidayPackageModel = (ArrayList<HolidayPackageModel>) getSession()
				.createQuery("FROM HolidayPackageModel WHERE packageName = ?").setParameter(0, packageName).list();
		if (holidayPackageModel.equals("[]")) {
			return null;
		}
		return holidayPackageModel.get(0);
	}

	@Override
	public String addPackage(HolidayPackage holidayPackage) {
		Boolean checkAmount = check(holidayPackage.getPackagePrice(), holidayPackage.getPackageDiscountPercent());

		if (checkAmount.equals(true)) {
			double discountAmount = discountCalculation(holidayPackage.getPackagePrice(),
					holidayPackage.getPackageDiscountPercent());
			HolidayPackageModel holidayPackageModel = new HolidayPackageModel();
			holidayPackageModel.setPackageName(holidayPackage.getPackageName());
			holidayPackageModel.setPackageDetail(holidayPackage.getPackageDetails());
			holidayPackageModel.setPackagePrice(holidayPackage.getPackagePrice());
			holidayPackageModel.setPackageDiscountPrice(discountAmount);

			getSession().save(holidayPackageModel);
			return "added";
		}

		return "Not added";
	}

	@Override
	public HolidayPackageModel updatePackage(HolidayPackage holidayPackage) {
		String name = getSession().createQuery("SELECT packageName FROM HolidayPackageModel WHERE packageName = ?")
				.setParameter(0, holidayPackage.getPackageName()).list().toString();
		String packageName = name.substring(1, name.length() - 1);
		System.out.println(packageName);
		if (holidayPackage.getPackageName().equals(packageName)) {
			Boolean checkAmount = check(holidayPackage.getPackagePrice(), holidayPackage.getPackageDiscountPercent());

			if (checkAmount.equals(true)) {
				double discountAmount = discountCalculation(holidayPackage.getPackagePrice(),
						holidayPackage.getPackageDiscountPercent());
				getSession()
						.createSQLQuery(
								"UPDATE holidaypackagemodel SET packageDetail = ?, packagePrice = ?,packageDiscountPrice = ? WHERE packageName = ?")
						.setParameter(0, holidayPackage.getPackageDetails())
						.setParameter(1, holidayPackage.getPackagePrice()).setParameter(2, discountAmount)
						.setParameter(3, packageName).executeUpdate();
			}
			ArrayList<HolidayPackageModel> holidayPackageModel = (ArrayList<HolidayPackageModel>) getSession()
					.createQuery("FROM HolidayPackageModel WHERE packageName = ?").setParameter(0, packageName).list();
			return holidayPackageModel.get(0);
		}
		return null;
	}

	@Override
	public String deletePackage(String packageName) {
		System.out.println("package name is " + packageName);
		String packageDetail = getSession()
				.createQuery("SELECT packageDetail FROM HolidayPackageModel WHERE packageName = ?")
				.setParameter(0, packageName).list().toString();
		System.out.println("packageDetail : " + packageDetail);
		if (packageDetail.equals("[]")) {
			return "Package not persent with this name";
		}
		getSession().createQuery("DELETE FROM HolidayPackageModel WHERE packageName = ?").setParameter(0, packageName)
				.executeUpdate();
		return "Package Deleted";
	}

}
