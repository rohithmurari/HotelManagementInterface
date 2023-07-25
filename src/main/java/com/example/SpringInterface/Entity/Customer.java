package com.example.SpringInterface.Entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="customer")
public class Customer {
	//CustomerDTO
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		
	
		private String firstName;
	
		private String lastName;
		private String fullName;
	
		private String email;
		private String password;
		
//		Getters and Setters
		public long getId() {
			return id;
		}
		
		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public void setId(long id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		//Constructors
		public Customer( String firstName, String lastName, String email, String password) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.password = password;
		}
		public Customer() {
			super();
		}
		
		public Customer(long id) {
			super();
			this.id = id;
		}
		@Override
		public String toString() {
			return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + 
					 ", email=" + email + ", password=" + password + "]";
		}
		
		
		

}
