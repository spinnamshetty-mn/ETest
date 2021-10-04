package com.epidemic.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epidemic.model.LatestResult;
import com.epidemic.repositories.LatestResultRepo;
import com.epidemic.repositories.TestResultRepo;

@Service
@Transactional
public class LatestResultService {
	
	@Autowired
	LatestResultRepo latestresult_repo;

//--------------------------Get Column / Latest Result by some condition-------------------------------------------------------
	public List<String> getAllState(){
		return latestresult_repo.findByState();
	}
	public String getLatestResult(int id) {  
		return latestresult_repo.findLatestResult(id);
	}
	public Date getLatestDate(int id) {
		return latestresult_repo.findLatestDate(id);
	}
	public String getHwName(int id) {
		return "";
	}
	public LatestResult getLatestResultPatient(int id) {  
		return latestresult_repo.findLatestResultPatient(id);
	}
	public List<LatestResult> displayActiveCases(String state) {
		return latestresult_repo.findAllActiveCases(state);
	}
//------------------------ get Count of latest result by some condition-----------------------
	
	public int getCountAllActiveCases() {
		return latestresult_repo.countAllActive();
	}
	public int getCountByHwId(int hwid) {
		return latestresult_repo.getCountByHwId(hwid);
	}
	
	public int countActiveByState(String state) {
		return latestresult_repo.getCountByState(state);
	}
	public int countActiveByCity(String city) {
		return latestresult_repo.getCountByCity(city);
	}
	public int CountActiveByPincode(int pincode) {
		return latestresult_repo.getCountByPincode(pincode);
	}
	public LatestResult getLatestResultPatient(int patientId, String diseaseType) {
		// TODO Auto-generated method stub
		
		
		return latestresult_repo.findLatestResultPatient(patientId,diseaseType);
	}
	public List<LatestResult> getLatestResultPatientList(int patientId) {
		// TODO Auto-generated method stub
		return latestresult_repo.getLatestResultList(patientId);
	}
	public int getCountByHwId(int id, String diseaseType) {
		// TODO Auto-generated method stub
		return latestresult_repo.getCountByHwId(id,diseaseType);
	}
}
