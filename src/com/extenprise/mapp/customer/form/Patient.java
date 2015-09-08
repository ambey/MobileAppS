package com.extenprise.mapp.customer.form;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.naming.NamingException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.extenprise.mapp.common.*;

public class Patient extends Customer {
	
	private float weight;

	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public void save() {
		
		try {
			
			QueryRunner run = new QueryRunner(DBManager.getDataSource());
			String query = "insert into Patient (idPatient,weight)"
					+ " values (?,?)";
			System.out.println("query is " + query);
			run.update(query, getIdCustomer(), weight);
		}
		catch (SQLException x) {
			System.out.println("SQLException : " + "Duplicate entry Patient");
			x.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void update() {
		try {
			QueryRunner run = new QueryRunner(DBManager.getDataSource());
			String query = "update Patient set weight=?"
			+ " where idPatient=?";
			System.out.println("query is " + query);
			run.update(query, weight, getIdCustomer());
			
		} catch (Exception x) {
			System.out.println("SQLException : " + "updating patient failed");
			x.printStackTrace();
		}	
	}
	
	public static Patient getPatient(String loginID, String passwd) {
		try {
			
			QueryRunner run = DBManager.getQueryRunner();
			ResultSetHandler<Patient> rsh = new BeanHandler<Patient>(
					Patient.class);
			String query = "select p.weight, c.* from Customer c, Patient p "
					+ "where c.emailId=? and c.passwd=? and p.idPatient=c.idCustomer";
			DebugManager.doAudit("Patient.getPatient: loginID = "
					+ loginID + ", passwd = " + passwd);
			return run.query(query, rsh, loginID, passwd);
		} catch (Exception x) {
			x.printStackTrace();
		}
		return null;
	}
	
	public static Patient getPatient(String loginID) {
		try {
			QueryRunner run = DBManager.getQueryRunner();
			ResultSetHandler<Patient> rsh = new BeanHandler<Patient>(
					Patient.class);
			String query = "select p.weight, c.* from Customer c, Patient p "
					+ "where c.emailId=? and p.idPatient=c.idCustomer";
			DebugManager.doAudit("Patient.getPatient: loginID = " + loginID);
			return run.query(query, rsh, loginID);
		} catch (Exception x) {
			x.printStackTrace();
		}
		return null;
	}

}
