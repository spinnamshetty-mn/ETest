package com.epidemic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epidemic.model.Government;
import com.epidemic.model.HealthWorker;
import com.epidemic.repositories.GovernmentRepo;
import com.epidemic.repositories.TestRequestRepo;

@Service
public class GovernmentService {
	
	@Autowired
	GovernmentRepo gov_repo;
	
	@Autowired
	TestRequestRepo test_request_repo;
//--------------------------------------------------------------------------------------------------------------
	
	public boolean addGov(Government gov) {
		if(searchGov(gov)!=null) {
			return false;		
		}
		gov.setStatus("pending");   // initially status will be pending in GOV DB
		gov_repo.save(gov);
		return true;
	}
	
	public void Update(Government gov) {
		gov_repo.save(gov);
	}
//---------------------------------search Gov Entity by diff condition--------------------------------------------------------
	public Government searchGov(Government gov) {
		// TODO Auto-generated method stub
		Government gov_db=gov_repo.findByEmail(gov.getEmail());
		return gov_db;
	}

	public Government searchGov(String email) {
		// TODO Auto-generated method stub
		return gov_repo.findByEmail(email);
	}
	
	
	public Government searchGov(int id) {
		// TODO Auto-generated method stub
		Government gov_db=gov_repo.findByGovId(id);
		return gov_db;
	}
	
	//----------------------------------------------------------------------------------------------------------------

	public boolean validate(String email, String password) {
		// TODO Auto-generated method stub
		Government gov_db=gov_repo.findByEmail(email);
		if(gov_db!=null) {
			return gov_db.getPassword().equals(password);
		}
		return false;
	}
//--------------------------------------------------------------------------------------
	
}
