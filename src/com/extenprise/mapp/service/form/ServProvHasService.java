package com.extenprise.mapp.service.form;

import java.util.ArrayList;

public class ServProvHasService {
	
	private float experience;
	private Service service;
	private ArrayList<ServProvHasServHasServPt> servicePoints;
	private ServiceProvider serviceProvider;
	
	
	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	public float getExperience() {
		return experience;
	}
	public void setExperience(float experience) {
		this.experience = experience;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public ArrayList<ServProvHasServHasServPt> getServicePoints() {
		return servicePoints;
	}
	public void setServicePoints(ArrayList<ServProvHasServHasServPt> servicePoints) {
		this.servicePoints = servicePoints;
	}

	
}
