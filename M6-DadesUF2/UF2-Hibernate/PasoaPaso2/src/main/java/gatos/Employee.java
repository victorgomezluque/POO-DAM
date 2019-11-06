package gatos;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee{
	
	@Id
	@Column(name = "id")
   private int id;
	
	@Column(name = "first_name")
   private String firstName; 
	
	@Column(name = "last_name")
   private String lastName;   
	
	@Column(name = "salary")
   private int salary;
	
	//el 99% de las veces, el tipo de cascada sera ALL
	@JoinColumn(name="address")
	@OneToOne(cascade = CascadeType.ALL)
   private Address address;

   public Employee() {}
   
   public Employee(int id, String fname, String lname, int salary, Address address ) {
	   this.id=id;
	   this.firstName = fname;
      this.lastName = lname;
      this.salary = salary;
      this.address = address;
   }
   
   public Employee(String fname, String lname, int salary, Address address ) {
	   this.id=id;
	   this.firstName = fname;
      this.lastName = lname;
      this.salary = salary;
      this.address = address;
   }
   
   
   public int getId() {
      return id;
   }
   
   public void setId( int id ) {
      this.id = id;
   }
   
   public String getFirstName() {
      return firstName;
   }
   
   public void setFirstName( String first_name ) {
      this.firstName = first_name;
   }
   
   public String getLastName() {
      return lastName;
   }
   
   public void setLastName( String last_name ) {
      this.lastName = last_name;
   }
   
   public int getSalary() {
      return salary;
   }
   
   public void setSalary( int salary ) {
      this.salary = salary;
   }

   public Address getAddress() {
      return address;
   }
   
   public void setAddress( Address address ) {
      this.address = address;
   }
}
