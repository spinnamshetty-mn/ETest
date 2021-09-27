package com.epidemic.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//-------------------for patient to add recently contacted person.

@Entity
@Table(name="contactlist")
public class ContactList {
	
	@Id
	@Column(name="s_no")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int s_no;
	
	@Column(name="mobile")
	private	long mobile;
	
	@Column(name="patient_id")
	private int patientid;
	
	@Column(name="name")
	private	String name;
	
	@Column(name="city")
	private	String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="pincode")
	private long pincode;
	
	@Column(name="contact_date")
	private Date contactDate;
	
	
	
	public ContactList() {
		
	}
	
	public ContactList( int patientId,String name, String city, String state, long pincode, long mobile , Date contact_date) {
		super();
		this.patientid=patientId;
		this.name = name;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobile = mobile;
		
		this.contactDate=contact_date;
	}

	public int getpatientId() {
		return patientid;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public long getPincode() {
		return pincode;
	}

	public long getMobile() {
		return mobile;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public Date getContactDate() {
		
		return new java.sql.Date(contactDate.getTime()) ;
	}

	public void setContactDate(Date contact_date) {
		this.contactDate = contact_date;
	}
	
	
}
