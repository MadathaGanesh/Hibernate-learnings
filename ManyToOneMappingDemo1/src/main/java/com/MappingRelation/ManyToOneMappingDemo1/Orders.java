package com.MappingRelation.ManyToOneMappingDemo1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="OrdersTable")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int OrderId;
	
	private String OrderedItem;
	
	private String OrderAddress;
	
	private int OrderAmount;
	
	@ManyToOne
	@JoinColumn(name = "custID")  // creating Foreign Key
	private Customer customerClassReference;
	
	public void setCustomerClassReference(Customer customerClassReference) {
		this.customerClassReference=customerClassReference;
	}
	
	public Customer getCustomerClassReference() {
		return customerClassReference;
	}
	
	public Orders() {}
	
	public Orders(String OrderedItem,String OrderAddress,int OrderAmount) {
		this.OrderAddress=OrderAddress;
		this.OrderedItem=OrderedItem;
		this.OrderAmount=OrderAmount;
	}

	public int getOrderId() {
		return OrderId;
	}

	public String getOrderedItem() {
		return OrderedItem;
	}

	public void setOrderedItem(String orderedItem) {
		OrderedItem = orderedItem;
	}

	public String getOrderAddress() {
		return OrderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		OrderAddress = orderAddress;
	}
	
	public void setOrderAmount(int OrderAmount) {
		this.OrderAmount=OrderAmount;
	}
	
	public int getOrderAmount() {
		return OrderAmount;
	}

	@Override
	public String toString() {
		return "Orders [OrderId=" + OrderId + ", OrderedItem=" + OrderedItem + ", OrderAddress=" + OrderAddress
				+ ", OrderAmount=" + OrderAmount + "]";
	}
	
	
	
	
}
