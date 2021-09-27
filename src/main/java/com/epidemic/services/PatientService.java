package com.epidemic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epidemic.model.Patient;
import com.epidemic.repositories.PatientRepo;

@Service
@Transactional
public class PatientService {
	
	@Autowired
	PatientRepo patient_repo;
	
//-----------------------------------------------------------------------------------------------------
	
	public boolean addPatient(Patient patient) { // adds patient into patient_db
		
		if(searchPatient(patient)!=null) {
			return false;
		}
		patient_repo.save(patient);
		return true;
	}
	
	public void addByPatient(Patient patient) {  
		patient_repo.save(patient);
	}
//--------------------------------------------------------------------------------------

	public Patient searchPatient(Patient patient) {
		// TODO Auto-generated method stub
		Patient p_db=patient_repo.findByEmail(patient.getEmail());
		return p_db;
	}
	public Patient searchPatient(String email) {
		// TODO Auto-generated method stub
		Patient p_db=patient_repo.findByEmail(email);
		return p_db;
	}
	public Patient searchPatient(int id) {
		// TODO Auto-generated method stub
		Patient p_db=patient_repo.findById(id);
		return p_db;
	}
	
//--------------------------------------------------------------------------------------------------
	
	public boolean validate(String email,String password) {
		Patient p_db=patient_repo.findByEmail(email);
		if(p_db!=null) {
			return p_db.getPassword().equals(password);
		
		}
		return false;
		
	}
//------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
}
