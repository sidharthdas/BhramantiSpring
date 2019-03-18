package com.sid.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "HolidayPackageModel")
@Table(name = "HolidayPackageModel")
public class HolidayPackageModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int packageId;
	private String packageName;
	private String packageDetail;
	private double packagePrice;
	private double packageDiscountPrice;
	@ManyToMany
	private Collection<UserDetails> users =  new ArrayList<>();
	
	
	public Collection<UserDetails> getUsers() {
		return users;
	}
	public void setUsers(Collection<UserDetails> users) {
		this.users = users;
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getPackageDetail() {
		return packageDetail;
	}
	public void setPackageDetail(String packageDetail) {
		this.packageDetail = packageDetail;
	}
	public double getPackagePrice() {
		return packagePrice;
	}
	public void setPackagePrice(double packagePrice) {
		this.packagePrice = packagePrice;
	}
	public double getPackageDiscountPrice() {
		return packageDiscountPrice;
	}
	public void setPackageDiscountPrice(double packageDiscountPrice) {
		this.packageDiscountPrice = packageDiscountPrice;
	}
	
	

}
