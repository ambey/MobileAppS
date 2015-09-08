package com.extenprise.mapp.customer.form;

import java.sql.*;
import java.util.ArrayList;

import com.extenprise.mapp.service.form.ServProvHasServHasServPt;

public class Appointment {
	
	private int idAppointment;
	private Time from, to;
	private Date date;
	private ArrayList<Report> reports;
	private Customer customer;
    private ServProvHasServHasServPt servProvHasServHasServPt;

	
	public ArrayList<Report> getReports() {
		return reports;
	}
	public void setReports(ArrayList<Report> reports) {
		this.reports = reports;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public ServProvHasServHasServPt getServProvHasServHasServPt() {
		return servProvHasServHasServPt;
	}
	public void setServProvHasServHasServPt(ServProvHasServHasServPt servProvHasServHasServPt) {
		this.servProvHasServHasServPt = servProvHasServHasServPt;
	}
	public ArrayList<Report> getReport() {
		return reports;
	}
	public void setReport(ArrayList<Report> reports) {
		this.reports = reports;
	}
	public int getIdAppointment() {
		return idAppointment;
	}
	public void setIdAppointment(int idAppointment) {
		this.idAppointment = idAppointment;
	}
	public Time getFrom() {
		return from;
	}
	public void setFrom(Time from) {
		this.from = from;
	}
	public Time getTo() {
		return to;
	}
	public void setTo(Time to) {
		this.to = to;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
