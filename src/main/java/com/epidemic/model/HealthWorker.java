package com.epidemic.model;

import javax.persistence.*;

@Entity
@Table(name="healthworker")

public class HealthWorker {
	
	@Id
	@Column(name="hw_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	private	String name;
	private	String address;
	private	String email;
	private	String password;
	private	Long mobile;
	private String type;
	private String approved_status;
	
	public HealthWorker() {
		
	}
	
	public HealthWorker(String name, String address, String email, String password, String mobile, String type,
			String approved_status) {
		super();
		this.name = name;
		this.address = address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	
	
	
}
