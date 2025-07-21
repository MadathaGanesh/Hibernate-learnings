package com.demo1.HibernateExampleDemo;

import jakarta.persistence.Embeddable;

@Embeddable
public class StudentFullAddress {
	
	private String City;
	private String State;
	private String Country;
	
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	@Override
	public String toString() {
		return "StudentFullAddress [City=" + City + ", State=" + State + ", Country=" + Country + "]";
	}
	
	
	

}
