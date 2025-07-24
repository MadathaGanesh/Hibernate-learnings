package com.MappingRelation.ManyToOneMappingDemo1;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="CustomerTable")
public class Customer {
	@Id
	private int custID;
	private String customerName;
	private String customerContactNumber;
	private String customerEmail;

	@OneToMany(mappedBy = "customerClassReference", cascade = CascadeType.ALL)
	private List<Orders> orderClassReference = new ArrayList<Orders>();
	
	public void setOrderClassReference(List<Orders> orderClassReference) {
		this.orderClassReference=orderClassReference;
	}
	
	public List<Orders> getOrderClassReference(){
		return orderClassReference;
	}	
	
	
	public void addOrderedItem(Orders orderedItem) {
		orderClassReference.add(orderedItem);
		orderedItem.setCustomerClassReference(this);
	}
	
	
	public void removeOrderedItem(Orders removeItem) {
		orderClassReference.remove(removeItem);
	}
	
	public Customer() {
	}


	public Customer(int custID, String customerName, String customerContactNumber, String customerEmail) {
		this.custID = custID;
		this.customerName = customerName;
		this.customerContactNumber = customerContactNumber;
		this.customerEmail = customerEmail;
	}


	public int getCustID() {
		return custID;
	}


	public void setCustID(int custID) {
		this.custID = custID;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerContactNumber() {
		return customerContactNumber;
	}


	public void setCustomerContactNumber(String customerContactNumber) {
		this.customerContactNumber = customerContactNumber;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	

}
