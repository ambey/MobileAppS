package com.extenprise.mapp.service.form;

import java.sql.Time;
import java.util.ArrayList;

import com.extenprise.mapp.customer.form.*;

public class ServProvHasServHasServPt {
	
	private String servPointType;
	private String weeklyOff;
	private Time startTime, endTime;
	private ArrayList<CustomerHistoryData> historyData;
    private ArrayList<Appointment> appointment;
    private ServicePoint servicePoint;
    private ServProvHasService servProvHasService;
    
	
	public ServicePoint getServicePoint() {
		return servicePoint;
	}
	public void setServicePoint(ServicePoint servicePoint) {
		this.servicePoint = servicePoint;
	}
	public ServProvHasService getServProvHasService() {
		return servProvHasService;
	}
	public void setServProvHasService(ServProvHasService servProvHasService) {
		this.servProvHasService = servProvHasService;
	}
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
	public String getServPointType() {
		return servPointType;
	}
	public void setServPointType(String servPointType) {
		this.servPointType = servPointType;
	}
	public String getWeeklyOff() {
		return weeklyOff;
	}
	public void setWeeklyOff(String weeklyOff) {
		this.weeklyOff = weeklyOff;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	
	
	
	
}
