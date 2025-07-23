package com.MappingRelation.OneToOneMapping;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="UserOneTOOne")
public class UserProfile {
	@Id
	private int userID;
	private String userName;
	private String Address;
	
	// Creating referen_Object for Passport class.
	@OneToOne()
	@JoinColumn(name = "passport_ID", unique = true)  // creating Foreign_Key using JoinColumn Annotation.
	private Passport passportObject;
	
	public void setUserID(int userID) {
		this.userID=userID;
	}
	
	public void setUserName(String userName) {
		this.userName=userName;
	}
	
	public void setAddress(String Address) {
		this.Address=Address;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getAddress() {
		return Address;
	}
	
	public void setPasspotObject(Passport passportObject) {
		this.passportObject=passportObject;
	}
	
	public Passport passportObject() {
		return passportObject;
	}
	
	

	@Override
	public String toString() {
		return "UserProfile [ User ID is: "+userID +" , userName=" + userName + ", Address=" + Address + "]";
	}
	
	
}
