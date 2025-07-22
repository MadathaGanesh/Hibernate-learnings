package com.MappingRelation.OneToMany;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="DepartmentOneToMany")
public class Department {
	
	@Id
	private int DeptID;
	private String DeptName;
	
	@OneToMany(mappedBy = "departmentReference",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Employee> employees = new ArrayList<Employee>();
	
	// Empty constructor
	public Department() {}
	
	//Single Parameter Constructor
	public Department(String DeptName) {
		this.DeptName=DeptName;
	}
	
	
	// Setters
	public void setEmployees(List<Employee> emp) {
		this.employees=emp;
	}
	
	public void setDeptID(int DeptID) {
		this.DeptID=DeptID;
	}
	
	public void setDeptName(String DeptName) {
		this.DeptName=DeptName;
	}
	
	//Getters
	public int getDeptID() {
		return DeptID;
	}
	
	public String getDeptName() {
		return DeptName;
	}
	
	public List<Employee> getEmployees(){
		return employees;
	}

	
	// Helper methods to addEmployee
	public void addEmployee(Employee emp) {
		employees.add(emp);
		emp.setDepartment(this);
	}
	
	public void removeEmployee(Employee emp) {
		employees.remove(emp);
		emp.setDepartment(null);
	}

	@Override
	public String toString() {
		return "Department [DeptID=" + DeptID + ", DeptName=" + DeptName + ", employees=" + employees + "]";
	}
	
	
	
	
	
}
