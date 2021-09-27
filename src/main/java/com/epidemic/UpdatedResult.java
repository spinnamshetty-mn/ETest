package com.epidemic;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

// used by hw.UploadedResult() to display store all the details of patients who have chosen a particular HW. 

public class UpdatedResult {
	private int patientId;
	
	private long reportId;
	
	private String firstName;
	
	private String lastName;
	
	private int hw_id;
	
	private String result;
	
	private Date contactDate;
	
	private int pincode;
	
	public UpdatedResult() {
		
	}
	
	public UpdatedResult(int patient_id, long report_id, String first_name, String last_name,
			String result,Date contactDate,int pincode) {
		super();
		this.patientId = patient_id;
		this.reportId = report_id;
		this.firstName = first_name;
		this.lastName = last_name;
		this.result = result;
		this.contactDate=contactDate;
		this.pincode=pincode;
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

	public int getHw_id() {
		return hw_id;
	}

	public void setHw_id(int hw_id) {
		this.hw_id = hw_id;
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
	
}
