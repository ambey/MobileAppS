package com.extenprise.mapp.service.form;

import java.sql.Date;

import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.struts.action.ActionForm;

import com.extenprise.mapp.common.*;


public class ServiceProvider extends ActionForm {
	
	private int idServiceProvider;
	private String fName, lName, phone, altPhone, emailId, passwd;
	private char gender;
	private Date subsDate;
	private boolean subscribed;
	private ArrayList<ServProvHasService> services;
	/*private ArrayList<String> serviceNames;
	private ArrayList<ServicePoint> servicePoint;
	private ArrayList<String> specialities;
	private float experience;*/
	
	
	public boolean isSubscribed() {
		return subscribed;
	}
	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	public ArrayList<ServProvHasService> getServices() {
		return services;
	}

	public void setServices(ArrayList<ServProvHasService> services) {
		this.services = services;
	}

	

	public int getIdServiceProvider() {
		return idServiceProvider;
	}

	public void setIdServiceProvider(int idServiceProvider) {
		this.idServiceProvider = idServiceProvider;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Date getSubsDate() {
		return subsDate;
	}

	public void setSubsDate(Date subsDate) {
		this.subsDate = subsDate;
	}

	public static ServiceProvider getDoctor(String loginID, String passwd) {
		try {
			QueryRunner run = DBManager.getQueryRunner();
			ResultSetHandler<ServiceProvider> rsh = new BeanHandler<ServiceProvider>(
					ServiceProvider.class);
			String query = "select * from ServiceProvider where emailId=? and passwd=?";
			DebugManager.doAudit("ServiceProvider.getDoctor: loginID = "
					+ loginID + ", passwd = " + passwd);
			return run.query(query, rsh, loginID, passwd);
		} catch (Exception x) {
			x.printStackTrace();
		}
		return null;
	}
	
	public static ServiceProvider getDoctor(String loginID) {
		try {
			QueryRunner run = DBManager.getQueryRunner();
			ResultSetHandler<ServiceProvider> rsh = new BeanHandler<ServiceProvider>(
					ServiceProvider.class);
			String query = "select * from ServiceProvider where emailId=?";
			DebugManager.doAudit("ServiceProvider.getDoctor: loginID = "
					+ loginID);
			return run.query(query, rsh, loginID);
		} catch (Exception x) {
			x.printStackTrace();
		}
		return null;
	}
	
	public String[] getColumnListForInsert() {
		return new String[] {
				"(fName,lName,gender,phone,altPhone,emailId,passwd,subsDate,subscribed)",
				"(?,?,?,?,?,?,?,?,?)" };
	}
	
	public String getColumnListForUpdate() {
		return "fName=?,lName=?,gender=?,"
				+ "phone=?,altPhone=?,emailId=?,passwd=?,subsDate=?,subscribed=?";

	}
	
	public Object[] toStringArray() {
		ArrayList<String> fields = new ArrayList<String>();
		int index = 0;
		fields.add(index++, fName);
		fields.add(index++, lName);
		fields.add(index++, "" + gender);
		fields.add(index++, phone);
		fields.add(index++, altPhone);
		fields.add(index++, emailId);
		fields.add(index++, passwd);
		fields.add(index++, "" + subsDate);
		fields.add(index++, "" + subscribed);

		return fields.toArray();
	}
}
