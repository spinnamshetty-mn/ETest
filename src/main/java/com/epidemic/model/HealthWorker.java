package com.epidemic.model;

import javax.persistence.*;

@Entity
@Table(name="healthworker")

public class HealthWorker {
	
	@Id
	@Column(name="hw_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	public void setId(int id) {
		this.id = id;
	}
	private	String name;
	private	String city;
	private String state;
	private int pincode;
	private	String email;
	private	String password;
	private	Long mobile;
	private String type;
	private String approved_status;
	
	public HealthWorker() {
		
	}
	
	public HealthWorker(String name, String email, String password, String mobile, String type,
			String approved_status,String city,String state,int pincode) {
		super();
		this.name = name;
		this.city=city;
		this.state=state;
		this.pincode=pincode;
		this.email = email;
		this.password = password;
		this.mobile = Long.parseLong(mobile);
		this.type = type;
		this.approved_status = approved_status;
	}
	
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getApproved_status() {
		return approved_status;
	}
	public void setApproved_status(String approved_status) {
		this.approved_status = approved_status;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
	
}
