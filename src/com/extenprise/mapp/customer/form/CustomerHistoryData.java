package com.extenprise.mapp.customer.form;

import java.io.File;
import java.sql.Date;

import com.extenprise.mapp.service.form.ServProvHasServHasServPt;

public class CustomerHistoryData {

    private int idCustomerHistoryData;
    private Date date;
    private Byte[] scannedCopy;
    private String reportType;
    private Customer customer;
    private ServProvHasServHasServPt servProvHasServHasServPt;

    
    
    public ServProvHasServHasServPt getServProvHasServHasServPt() {
		return servProvHasServHasServPt;
	}

	public void setServProvHasServHasServPt(ServProvHasServHasServPt servProvHasServHasServPt) {
		this.servProvHasServHasServPt = servProvHasServHasServPt;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public int getIdCustomerHistoryData() {
        return idCustomerHistoryData;
    }

    public void setIdCustomerHistoryData(int idCustomerHistoryData) {
        this.idCustomerHistoryData = idCustomerHistoryData;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Byte[] getScanedCopy() {
        return scannedCopy;
    }

    public void setScanedCopy(Byte[] scannedCopy) {
        this.scannedCopy = scannedCopy;
    }

}