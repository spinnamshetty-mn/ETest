package com.epidemic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

// Join tables of Test Request and Patient Table.
public class joinclass {
	
	private int patient_id;
	
	private long report_id;
	
	private String first_name;
	
	private String last_name;
	
	private int hw_id;
	
	

	public joinclass(){
		
	}
	
	public joinclass(int patient_id, long report_id, String firstname,String lastname,int hw_id) {
		super();
		this.patient_id = patient_id;
		this.report_id = report_id;
		this.first_name = firstname;
		this.last_name=lastname;
		this.hw_id=hw_id;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public long getReport_id() {
		return report_id;
	}

	public void setReport_id(long report_id) {
		this.report_id = report_id;
	}

	

	public int getHw_id() {
		return hw_id;
	}

	public void setHw_id(int hw_id) {
		this.hw_id = hw_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	

	
	
	
}
