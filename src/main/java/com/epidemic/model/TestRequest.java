package com.epidemic.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import java.time.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="testrequest")

public class TestRequest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="report_id")
	private long id;
	
	@Column(name="patient_id")
	private int patientId;
	

	@Column(name="hw_id")
	private int hwId;

	@OneToOne(targetEntity= Patient.class,cascade=CascadeType.PERSIST)
	@JoinColumn(name="patient_id",referencedColumnName="patient_id" , insertable = false, updatable = false)
	private Patient patient;
	
	TestRequest(){
		
	}
	
	public TestRequest(int patient_id,int hw_id) {
		super();
		this.patientId=patient_id;
		this.hwId = hw_id;
	}
	
	public long getId() {
		return id;
	}
	
	public int getHwId() {
		return hwId;
	}
	public int getPatientId() {
		return patientId;
	}
	
}
