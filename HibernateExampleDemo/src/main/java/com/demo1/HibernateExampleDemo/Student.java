package com.demo1.HibernateExampleDemo;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table()
@Entity
public class Student {
	
	@Id
	private int StudID;
	private String StudName;
	private String PhoneNumber;
	
	// Taking student Address data from "StudentFullAddress class".
	@Embedded
	private StudentFullAddress fullAddress;
	
	
	public void setStudID(int StudID) {
		this.StudID=StudID;
	}
	
	

	public void setStudName(String StudName) {
		this.StudName=StudName;
	}
	
	public void setPhoneNumber(String PhoneNumber) {
		this.PhoneNumber=PhoneNumber;
	}
	
	
	public int getStudID() {
		return StudID;
	}
	
	public String getStudName() {
		return StudName;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}
	
	
	public void setStudentFullAddress(StudentFullAddress fullAddress) {
		this.fullAddress=fullAddress;
	}
	
	
	public StudentFullAddress getStudentFullAddress() {
		return fullAddress;
	}



	@Override
	public String toString() {
		return "Student [StudID=" + StudID + ", StudName=" + StudName + ", PhoneNumber=" + PhoneNumber
				+ ", fullAddress=" + fullAddress + "]";
	}
	
	
	
}
