package com.MappingRelation.OneToOneMapping;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="passportOneToOne")
public class Passport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int passport_ID;
	
	@Column(unique = true,nullable = false)
	private String passport_Number;
	private String country;
	private LocalDate IssueDate;
	
	
	// Creating reference to "UserProfile class" and mapping it by using "passportObject" reference.
 	@OneToOne(mappedBy ="passportObject",cascade = CascadeType.ALL)
	private UserProfile userprofile;
	
	public int getPassport_ID() {
		return passport_ID;
	}


	public void setPassport_ID(int passport_ID) {
		this.passport_ID = passport_ID;
	}

	public String getPassport_Number() {
		return passport_Number;
	}

	public void setPassport_Number(String passport_Number) {
		this.passport_Number = passport_Number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDate getIssueDate() {
		return IssueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		IssueDate = issueDate;
	}

	
	public void setUserprofile(UserProfile userProfile) {
		this.userprofile=userProfile;
	}
	
	
	public UserProfile getUserprofile() {
		return userprofile;
	}
	
	
	@Override
	public String toString() {
		return "Passport [passport_ID=" + passport_ID + ", passport_Number=" + passport_Number + ", country=" + country
				+ ", IssueDate=" + IssueDate + "]";
	}
	
}




