package com.extenprise.mapp.customer.form;

import java.io.File;

public class Report {
	
	private int idReport;
	private Byte[] scannedCopy;
	private String reportType;
	private Appointment appointment;

	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public int getIdReport() {
		return idReport;
	}
	public void setIdReport(int idReport) {
		this.idReport = idReport;
	}
	public Byte[] getScannedCopy() {
		return scannedCopy;
	}
	public void setScannedCopy(Byte[] scannedCopy) {
		this.scannedCopy = scannedCopy;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}


}
