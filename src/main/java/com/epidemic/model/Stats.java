package com.epidemic.model;

//------------------------for storing info to be displayed at GOV result tab-------------

public class Stats {
	
	private int activeCases;
	private int tests;
	private int infected;
	private float positiveRate;
	private String zone;
	
	public Stats(int activeCases, int tests, int infected, float positiveRate) {
		super();
		this.activeCases = activeCases;
		this.tests = tests;
		this.infected = infected;
		this.positiveRate = positiveRate;
		
	}

	public int getActiveCases() {
		return activeCases;
	}

	public void setActiveCases(int activeCases) {
		this.activeCases = activeCases;
	}

	public int getTests() {
		return tests;
	}

	public void setTests(int tests) {
		this.tests = tests;
	}

	public int getInfected() {
		return infected;
	}

	public void setInfected(int infected) {
		this.infected = infected;
	}

	public float getPositiveRate() {
		return positiveRate;
	}

	public void setPositiveRate(float positiveRate) {
		this.positiveRate = positiveRate;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}
	
	
	
}
