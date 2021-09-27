package com.epidemic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="latestresult")

public class LatestResult {
	
	@Id
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="result_id")
	private int resultId;
	
	
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
	
	public LatestResult() {
		
	}
	
	public LatestResult(int resultId, int patientId, long reportId, int hwId, String status,Date date2, String city,
			String state, int pincode) {
		super();
		this.resultId = resultId;
		this.patientId = patientId;
		this.reportId = reportId;
		this.hwId = hwId;
		this.status = status;
		this.date = date2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
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
	
	
	
	
}
