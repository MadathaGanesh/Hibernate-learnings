package com.MappingRelation.ManyToManyLibraryManagement;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "BookManyToMany")
public class Book {
	
	@Id
	private int BookID;
	private String BookName;
	private int BookPrice;
	private int TotalBooksTaken;
	
	@ManyToMany(mappedBy = "BookClassReference")
	private Set<Student> StudentClassReference = new HashSet<Student>();
	
	public void setStudentClassReference(Set<Student> StudentClassReference) {
		this.StudentClassReference=StudentClassReference;
	}
	
	public Set<Student> getStudentClassReference() {
		return StudentClassReference;
	}
	
	
	
	// Two way binding
	public void addStudents(Student studentreference) {
		this.StudentClassReference.add(studentreference);
		studentreference.getBookClassReference().add(this);
		
	}
	
	public void removeStudents(Student studentreference) {
		this.StudentClassReference.remove(studentreference);
		studentreference.getBookClassReference().remove(this);
	}
	
	
	
	public Book() {}
	
	public Book(int bookID, String bookName, int bookPrice, int totalBooksTaken) {
		BookID = bookID;
		BookName = bookName;
		BookPrice = bookPrice;
		TotalBooksTaken = totalBooksTaken;
	}

	public int getBookID() {
		return BookID;
	}

	public void setBookID(int bookID) {
		BookID = bookID;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public int getBookPrice() {
		return BookPrice;
	}

	public void setBookPrice(int bookPrice) {
		BookPrice = bookPrice;
	}

	public int getTotalBooksTaken() {
		return TotalBooksTaken;
	}

	public void setTotalBooksTaken(int totalBooksTaken) {
		TotalBooksTaken = totalBooksTaken;
	}

	@Override
	public String toString() {
		return "Book [BookID=" + BookID + ", BookName=" + BookName + ", BookPrice=" + BookPrice + ", TotalBooksTaken="
				+ TotalBooksTaken + "]";
	}
	
	
	@Override
	public boolean equals(Object o) {
		if(this==o) return true;
		if(!(o instanceof Book)) return false;
		Book bookobj = (Book) o;
		return BookID == bookobj.BookID;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(BookID);
	}
	

}
