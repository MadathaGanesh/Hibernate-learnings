package com.MappingRelation.OneToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="EmployeeOneToMany")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int EmpID;
	private String EmpName;
	private String EmpAddress;
	
	@ManyToOne()
	@JoinColumn(name = "DeptID")   // Adding foreignKey
	private Department departmentReference;
	
	
	//Constructors
	public Employee() {}
	
	public Employee(String EmpName,String EmpAddress) {
		this.EmpName=EmpName;
		this.EmpAddress=EmpAddress;
	}
	
	public void setDepartment(Department dept) {
		this.departmentReference=dept;
	}
	
	public void setEmpName(String EmpName) {
		this.EmpName=EmpName;
	}

	public void setEmpAddress(String EmpAddress) {
		this.EmpAddress=EmpAddress;
	}
	
	
	public Department getDepartment() {
		return departmentReference;
	}
	
	public String getEmpName() {
		return EmpName;
	}
	
	public String getEmpAddress() {
		return EmpAddress;
	}

	@Override
	public String toString() {
		return "Employee [EmpID=" + EmpID + ", EmpName=" + EmpName + ", EmpAddress=" + EmpAddress + "]";
	}
	
	
}
