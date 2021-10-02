package com.epidemic.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="testresult")
public class TestResult {

	@Id
	@Column(name="result_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int resultId;
	
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="report_id")
	private long reportId;
	
	@Column(name="hw_id")
	private int hwId;
	
	@Column(name="status")
	private String status;
	
	@Column(name="result_date")
	private Date date;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="pincode")
	private int pincode;
	
	@Column(name="disease_type")
	private String diseaseType;
	
	@Column(name="test_type")
	private String testType;
	
	@ManyToOne(targetEntity= Patient.class,cascade=CascadeType.PERSIST)
	@JoinColumn(name="patient_id",referencedColumnName="patient_id" , insertable = false, updatable = false)
	private Patient patient;
	
	public TestResult() {
		
	}
	
	public TestResult(int patientId, long reportId, int hwId, String status, Date date,String city,String state,int pincode,String diseaseType,String testType) {
		super();
		this.patientId = patientId;
		this.reportId = reportId;
		this.hwId = hwId;
		this.status = status;
		this.date = date;
		this.city=city;
		this.state=state;
		this.pincode=pincode;
		this.diseaseType=diseaseType;
		this.testType=testType;
	}
	
	

	public TestResult(int patientId, long report_id, int hwId, String status,String city,String state,int pincode,String diseaseType,String testType) {
		super();
		this.patientId = patientId;
		this.reportId = report_id;
		this.hwId = hwId;
		this.status = status;
		this.city=city;
		this.state=state;
		this.pincode=pincode;
		this.diseaseType=diseaseType;
		this.testType=testType;
	}

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	public int getHwId() {
		return hwId;
	}

	public void setHwId(int hwId) {
		this.hwId = hwId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return new java.sql.Date(date.getTime()) ;
	}

	public void setDate(Date date) {
		this.date = date;
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
