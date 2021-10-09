package com.epidemic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="epidemic")
public class Disease {

	
	@Id
	@Column(name="s_no")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="disease")
	private	String disease;
	
	@Column(name="test")
	private String test;
	
	
	public Disease() {
		
	}
	
	public Disease(String disease,String test) {
		super();
		this.disease = disease;
		this.test=test;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisease() {
		return disease;
	}
//
	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
	
}
