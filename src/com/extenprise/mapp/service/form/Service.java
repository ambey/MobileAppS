package com.extenprise.mapp.service.form;

import java.util.ArrayList;

public class Service {
	
	private int idService;
	private String name, speciality;
	private ArrayList<ServProvHasService> servProvHasService;
	
	
	public ArrayList<ServProvHasService> getServProvHasService() {
		return servProvHasService;
	}
	public void setServProvHasService(ArrayList<ServProvHasService> servProvHasService) {
		this.servProvHasService = servProvHasService;
	}
	public int getIdService() {
		return idService;
	}
	public void setIdService(int idService) {
		this.idService = idService;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	

}
