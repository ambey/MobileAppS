package com.extenprise.mapp.service.form;

import java.util.ArrayList;

public class ServicePoint {
	
	private int idServicePoint;
	private String name, location, phone, altPhone, emailId, city, state, country;
	private ArrayList<ServProvHasServHasServPt> servProvHasServHasServPt;
	
	
	public ArrayList<ServProvHasServHasServPt> getServProvHasServHasServPt() {
		return servProvHasServHasServPt;
	}
	public void setServProvHasServHasServPt(ArrayList<ServProvHasServHasServPt> servProvHasServHasServPt) {
		this.servProvHasServHasServPt = servProvHasServHasServPt;
	}
	public int getIdServicePoint() {
		return idServicePoint;
	}
	public void setIdServicePoint(int idServicePoint) {
		this.idServicePoint = idServicePoint;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAltPhone() {
		return altPhone;
	}
	public void setAltPhone(String altPhone) {
		this.altPhone = altPhone;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

}
