package com.epidemic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="government")
public class Government {

	@Id
	@Column(name="gov_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int govId;
	
	public void setGovId(int govId) {
		this.govId = govId;
	}
	private String email;
	private String password;
	private String status;
	private String state;
	
	public Government(){
		
	}
	public Government(String email, String passsword,String state) {
		super();
		this.email = email;
		this.password = passsword;
		this.state=state;
	}
	public int getGovId() {
		return govId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
