package com.epidemic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epidemic.model.HealthWorker;
import com.epidemic.model.Patient;
import com.epidemic.repositories.HealthWorkerRepo;

@Service
public class HealthWorkerService {
	
	@Autowired
	HealthWorkerRepo hw_repo;
	
//--------------------------------------------------------------------------------------------
	public boolean addWorker(HealthWorker hw) {
		
		if(searchWorker(hw)!=null) {
			return false;
			
		}
		hw.setApproved_status("pending");
		hw_repo.save(hw);
		return true;
		
	}
	
	public void updateRequest(int id) {    // approve hw method 
		HealthWorker hw=hw_repo.findById(id);
		hw.setApproved_status("approved");
		hw_repo.save(hw);
	}
	public void deleteRequest(int id) {
		hw_repo.deleteById(id);
	}
	
//-------------------------------------------------------------------------------------------------------
	public boolean validate(String email,String password) {
		HealthWorker hw_db=hw_repo.findByEmail(email);
		if(hw_db!=null) {
			return hw_db.getPassword().equals(password);
		
		}
		return false;
		
	}
//---------------------------------------------------------------------------------------------------------
	
	public HealthWorker searchWorker(HealthWorker hw) {
		// TODO Auto-generated method stub
		HealthWorker hw_db=hw_repo.findByEmail(hw.getEmail());
		return hw_db;
	}
	
	public HealthWorker searchWorker(int id) {
		// TODO Auto-generated method stub
		HealthWorker hw_db=hw_repo.findById(id);
		return hw_db;
	}
	
	
	public HealthWorker searchWorker(String email) {
		HealthWorker hw_db=hw_repo.findByEmail(email);
		return hw_db;
	}
//----------------------------------------------------------------------------------------------------------------
	
	
	public List<HealthWorker> findActiveHW(){
		return hw_repo.findByActiveHw();
	}
	public List<HealthWorker> displayAllHW(){
		return hw_repo.findAllHW();
	}
	public List<HealthWorker> displayPendingHW(){
		return hw_repo.findAllPendingHw();
	}
	
	public List<HealthWorker> displayPendingHWInState(String state){
		return hw_repo.findAllPendingHwInState(state);
	}
	public void update(HealthWorker hw) {
		hw_repo.save(hw);
	}
}
