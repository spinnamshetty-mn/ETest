package com.epidemic.model;

import java.util.*;

import javax.persistence.*;

import com.epidemic.EncryptPassword;

@Entity
@Table(name="Patient")

public class Patient {
	
	@Id
	@Column(name="patient_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private	String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private	String email;
	
	@Column(name="password")
	private	String password;
	
	@Column(name="mobile")
	private	Long mobile;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="pincode")
	private int pincode;

	public Patient() {
		
	}
	
	public Patient(String firstname,String lastname, String email, String password,String mobile,String city,String state,int pincode) {
		super();
		this.firstName = firstname.toUpperCase();
		this.lastName=lastname.toUpperCase();
		this.email = email;
		this.password=password;
		this.mobile=Long.parseLong(mobile);
		this.city=city.toUpperCase();
		this.state=state.toUpperCase();
		this.pincode=pincode;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public long getMobile() {
		return mobile;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getId() {
		return id;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public int getPincode() {
		return pincode;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}

	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
}
