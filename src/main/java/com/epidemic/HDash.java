package com.epidemic;

public class HDash {

	private String diseaseType;
	
	private int totalTests;
	
	private int pendingTests;
	
	private int totalActiveCases;

	public HDash(String diseaseType, int totalTests, int pendingTests, int totalAciveCases) {
		super();
		this.diseaseType = diseaseType;
		this.totalTests = totalTests;
		this.pendingTests = pendingTests;
		this.totalActiveCases = totalAciveCases;
	}

	public String getDiseaseType() {
		return diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}

	public int getTotalTests() {
		return totalTests;
	}

	public void setTotalTests(int totalTests) {
		this.totalTests = totalTests;
	}

	public int getPendingTests() {
		return pendingTests;
	}

	public void setPendingTests(int pendingTests) {
		this.pendingTests = pendingTests;
	}

	public int getTotalActiveCases() {
		return totalActiveCases;
	}

	public void setTotalActiveCases(int totalAciveCases) {
		this.totalActiveCases = totalAciveCases;
	}
	
	
	
	
}
