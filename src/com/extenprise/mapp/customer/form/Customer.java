package com.extenprise.mapp.customer.form;

import java.sql.*;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.struts.action.ActionForm;

import com.extenprise.mapp.common.*;


public class Customer extends ActionForm {
	
	private int idCustomer;
	private Date dob;
	private char gender;
	private String fName;
    private String lName;
    private String phone;
    private String emailId;
    private String altPhone;
    private String location;
    private String city;
    private String state;
    private String country;
    private String passwd;
    private ArrayList<CustomerHistoryData> historyData;
    private ArrayList<Appointment> appointment;
	

	public ArrayList<CustomerHistoryData> getHistoryData() {
		return historyData;
	}

	public void setHistoryData(ArrayList<CustomerHistoryData> historyData) {
		this.historyData = historyData;
	}

	public ArrayList<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(ArrayList<Appointment> appointment) {
		this.appointment = appointment;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAltPhone() {
		return altPhone;
	}

	public void setAltPhone(String altPhone) {
		this.altPhone = altPhone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public static Customer getCustomer(String loginID) {
		try {
			QueryRunner run = DBManager.getQueryRunner();
			ResultSetHandler<Customer> rsh = new BeanHandler<Customer>(
					Customer.class);
			String query = "select * from Customer where emailId=?";
			DebugManager.doAudit("Customer.getCustomer: loginID = "
					+ loginID);
			return run.query(query, rsh, loginID);
		} catch (Exception x) {
			x.printStackTrace();
		}
		return null;
	}
	
	public static Customer getCustomer(String loginID, String passwd) {
		try {
			QueryRunner run = DBManager.getQueryRunner();
			ResultSetHandler<Customer> rsh = new BeanHandler<Customer>(
					Customer.class);
			String query = "select * from Customer where emailId=? and passwd=?";
			DebugManager.doAudit("Customer.getCustomer: loginID = "
					+ loginID + ", passwd = " + passwd);
			return run.query(query, rsh, loginID, passwd);
		} catch (Exception x) {
			x.printStackTrace();
		}
		return null;
	}
	
	public String[] getColumnListForInsert() {
		return new String[] {
				"(dob, fName, lName, gender, phone, altPhone, emailId,  "
				+ "location, city, state, country, passwd)",
				"(?,?,?,?,?,?," + "?,?,?,?,?,?)" };
	}
	
	public String getColumnListForUpdate() {
		return "dob=?,fName=?,lName=?,gender=?"
				+ "phone=?,altPhone=?,emailId=?,location=?,city=?,"
				+ "state=?,country=?,passwd=?";

	}
	
	public Object[] toStringArray() {
		ArrayList<String> fields = new ArrayList<String>();
		int index = 0;
		fields.add(index++, "" + dob);
		fields.add(index++, fName);
		fields.add(index++, lName);
		fields.add(index++, "" + gender);
		fields.add(index++, phone);
		fields.add(index++, altPhone);
		fields.add(index++, emailId);
		fields.add(index++, location);
		fields.add(index++, city);
		fields.add(index++, state);
		fields.add(index++, country);
		fields.add(index++, passwd);

		return fields.toArray();
		// 
	}
}