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

	@Column(name="disease_type")
	private String diseaseType;
	
	@Column(name="test_type")
	private String testType;
	
	@OneToOne(targetEntity= Patient.class,cascade=CascadeType.PERSIST)
	@JoinColumn(name="patient_id",referencedColumnName="patient_id" , insertable = false, updatable = false)
	private Patient patient;
	
	TestRequest(){
		
	}
	
	public TestRequest(int patient_id,int hw_id,String diseaseType,String testType) {
		super();
		this.patientId=patient_id;
		this.hwId = hw_id;
		this.diseaseType=diseaseType;
		this.testType=testType;
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

	public String getDiseaseType() {
		return diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}
	
	
}
