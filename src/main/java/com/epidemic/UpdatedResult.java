package com.epidemic;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data

@ToString

// used by hw.UploadedResult() to display store all the details of patients who have chosen a particular HW. 

public class UpdatedResult {
	private int patientId;
	
	private long reportId;
	
	private String firstName;
	
	private String lastName;
	
	private int hwId;
	
	private String result;
	
	private Date contactDate;
	
	private int pincode;
	
	private String diseaseType;
	
	private String testType;
	
	public UpdatedResult() {
		
	}
	
	public UpdatedResult(int patient_id, long report_id, String first_name, String last_name,
			String result,Date contactDate,int pincode,String diseaseType,String testType) {
		super();
		this.patientId = patient_id;
		this.reportId = report_id;
		this.firstName = first_name;
		this.lastName = last_name;
		this.result = result;
		this.contactDate=contactDate;
		this.pincode=pincode;
		this.diseaseType=diseaseType;
		this.testType=testType;
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

	public int getHwId() {
		return hwId;
	}

	public void setHwId(int hw_id) {
		this.hwId = hw_id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Date getContactDate() {
		return new java.sql.Date(contactDate.getTime());
	}

	public void setContactDate(Date contactDate) {
		this.contactDate = contactDate;
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
