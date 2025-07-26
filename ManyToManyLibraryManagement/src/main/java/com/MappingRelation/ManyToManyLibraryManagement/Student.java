package com.MappingRelation.ManyToManyLibraryManagement;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="StudentManyToMany")
public class Student {
	
	@Id
	public int StudentID;
	public String StudentName;
	public String branch;
	public String StudentAddress;
	
	
	@ManyToMany
	@JoinTable(name = "BookStudentTableManyToMany",
	joinColumns = @JoinColumn(name="StudentID"),
	inverseJoinColumns = @JoinColumn(name="BookID"))
	private Set<Book> BookClassReference=new HashSet<Book>();
	
	public Set<Book> getBookClassReference() {
		return BookClassReference;
	}


	public void setBookClassReference(Set<Book> bookClassReference) {
		BookClassReference = bookClassReference;
	}


	
	//Two way Binding
	public void addBooks(Book bookreference) {
		this.BookClassReference.add(bookreference);
		bookreference.getStudentClassReference().add(this);
	}
	
	
	public void removeBooks(Book bookreference) {
		this.BookClassReference.remove(bookreference);
		bookreference.getStudentClassReference().remove(this);
	}
	
	
	
	public Student() {}

	public Student(int StudentID,String StudentName, String branch, String StudentAddress) {
		this.StudentID=StudentID;
		this.StudentName=StudentName;
		this.StudentAddress=StudentAddress;
		this.branch=branch;
	}


	public int getStudentID() {
		return StudentID;
	}


	public void setStudentID(int studentID) {
		StudentID = studentID;
	}


	public String getStudentName() {
		return StudentName;
	}


	public void setStudentName(String studentName) {
		StudentName = studentName;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	public String getStudentAddress() {
		return StudentAddress;
	}


	public void setStudentAddress(String studentAddress) {
		StudentAddress = studentAddress;
	}


	@Override
	public String toString() {
		return "Student [StudentID=" + StudentID + ", StudentName=" + StudentName + ", branch=" + branch
				+ ", StudentAddress=" + StudentAddress + "]";
	}
	
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Student)) return false;
		Student studentobj= (Student) o;
		return StudentID == studentobj.StudentID;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hashCode(StudentID);
	}
	
	
	
}
