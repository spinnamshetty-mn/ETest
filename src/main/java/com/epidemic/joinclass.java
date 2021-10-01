package com.epidemic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data

@ToString

// Join tables of Test Request and Patient Table.
public class joinclass {
	
	private int patientId;
	
	private long reportId;
	
	private String firstName;
	
	private String lastName;
	
	private int hwId;
	
	private String testType;
	
	private String diseaseType;
	
	private String state;

	public joinclass(){
		
	}
	
	public joinclass(int patient_id, long report_id, String firstname,String lastname,int hw_id,String diseasetype,String testType) {
		super();
		this.patientId = patient_id;
		this.reportId = report_id;
		this.firstName = firstname;
		this.lastName=lastname;
		this.hwId=hw_id;
		this.testType=testType;
		this.diseaseType=diseasetype;
	}
	
	public joinclass(int patient_id, long report_id,int hw_id,String diseasetype,String testType) {
		super();
		this.patientId = patient_id;
		this.reportId = report_id;
		this.hwId=hw_id;
		this.testType=testType;
		this.diseaseType=diseasetype;
		
	}
	
	
	
	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patient_id) {
		this.patientId = patient_id;
	}

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long report_id) {
		this.reportId = report_id;
	}

	public int getHwId() {
		return hwId;
	}

	public void setHwId(int hw_id) {
		this.hwId = hw_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getDiseaseType() {
		return diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

	
	
	
}
