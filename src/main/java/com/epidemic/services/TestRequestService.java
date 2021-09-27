package com.epidemic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epidemic.joinclass;
import com.epidemic.model.TestRequest;
import com.epidemic.repositories.TestRequestRepo;

@Service
@Transactional
public class TestRequestService {
	
	@Autowired
	TestRequestRepo test_request_repo;

//-----------------------------------------------------------------------------------------------------------------
	public TestRequest findTest(int patient_id) {
		return test_request_repo.findByPatientId(patient_id);
	}
//-----------------------------------------------------------------------------------------------
	public void add(TestRequest test) { // add test request to db
		test_request_repo.save(test);
	}
//------------------------------------------------------------------------------------------
	public  List<TestRequest> displayRequest(int hwId){	
		return test_request_repo.findByHwId( hwId);
	}
//----------------------------------------------------------------------------------------
	public List<joinclass> getInformation(int id) {  //id=hwId
		return test_request_repo.getInfo(id);
	}
//----------------------------------------------------------------------------------------
	public List<joinclass> getInformation(){ 
		return test_request_repo.getInfo();
	}
//-----------------------------------------------------------------------------------------
	public TestRequest findRequest(long report_id) {
		return test_request_repo.findById(report_id);
	}
	
	public int countPendingByHw(int hwid) {
		return test_request_repo.pendingByHw(hwid);
	}
	
	public List<TestRequest> diplayAllRequest(){
		return test_request_repo.displayAllRequest();
	}
	
	
}
