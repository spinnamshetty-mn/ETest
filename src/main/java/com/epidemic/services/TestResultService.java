package com.epidemic.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.epidemic.joinclass;
import com.epidemic.model.LatestResult;
import com.epidemic.model.Patient;
import com.epidemic.model.TestRequest;
import com.epidemic.model.TestResult;
import com.epidemic.repositories.LatestResultRepo;
import com.epidemic.repositories.PatientRepo;
import com.epidemic.repositories.TestRequestRepo;
import com.epidemic.repositories.TestResultRepo;

@Service
@Transactional
public class TestResultService {
	
	@Autowired
	private TestResultRepo test_result_repo;
	
	@Autowired
	private TestRequestService test_request_service;
	
	@Autowired
	private TestRequestRepo test_request_repo;
	
	@Autowired
	private LatestResultService latest_result_service;
	
	@Autowired
	private PatientService patient_service;
	
	@Autowired
	private LatestResultRepo latest_result_repo;
	
//-----------------------------------------------------------------------------------------------------------------------
	
	public void add(long report_id,String result) {
		TestRequest test_request=test_request_service.findRequest(report_id);
		int patientId=test_request.getPatientId();
		int hwId=test_request.getHwId();
		// get city and state from patient and put on test result
		String diseaseNew=test_request.getDiseaseType();
		String testNew=test_request.getTestType();
		
		Patient p=patient_service.searchPatient(patientId);
		int pincode=p.getPincode();
	
		TestResult tr=new TestResult(patientId,report_id,hwId,result,p.getCity(),p.getState(),p.getPincode(),diseaseNew,testNew);
		
		test_result_repo.save(tr);
		
		test_request_repo.delete(test_request);
		
		//find remaninig details from result table and save in latest result
		
		TestResult t=test_result_repo.findByReportId(report_id);
		
		int resultId=t.getResultId();
		
		
		String state=t.getState();
		String city=t.getCity();
		String status=t.getStatus();
		Date date=test_result_repo.findByDate(report_id);
		t.setDate(date);
	
		
		LatestResult lr =latest_result_service.getLatestResultPatient(patientId,diseaseNew);
		
		
		if(lr!=null){
			//update
			
			System.out.println(lr.getPatientId() +" "+ lr.getDiseaseType());
			lr.setResultId(resultId);
			lr.setStatus(status);
			lr.setHwId(hwId);
			lr.setDate(date);
			lr.setReportId(report_id);
			lr.setTestType(testNew);
			latest_result_repo.save(lr);
			return;
		}
		//add new in latestresult
		
		LatestResult latestResult=new LatestResult(resultId,patientId,report_id,hwId,status,date,city,state,pincode,diseaseNew,testNew);
		latest_result_repo.save(latestResult);
		
	}
	 //for displaying all result for a single patient
	public List<TestResult> findAllPatientResult(int patientId){
		return test_result_repo.findAllByPatient(patientId);
	}
	
	// for displaying latest result of a single patient
	public void findByPatient(int patientId) {
		test_result_repo.findByPatient(patientId).getReportId();
	}
	
	public List<TestResult> findAllResultsByHW(int hwId){
		return test_result_repo.findByOrderByHwIdDesc(hwId);
		
	}
	public List<String> getAllState(){
		List<String> list=test_result_repo.findByState();
		return list;
	}
	
	public List<String> getAllCity(){
		List<String> list=test_result_repo.findByCity();
		return list;
	}
	public List<String> getAllPincode(){
		return test_result_repo.findByPincode();
	}
	
	public int totalTestState(String name) {
		return test_result_repo.totalTestState(name);
	}
	public int totalTestCity(String name) {
		return test_result_repo.totalTestCity(name);
	}
	public int totalTestPincode(int name) {
		return test_result_repo.totalTestPincode(name);
	}
	
	public int totalCasesState(String name) {
	
		int t=test_result_repo.totalCasesState(name);
		
		return test_result_repo.totalCasesState(name);
	}
	
	public int totalCasesCity(String name) {
		
		int t=test_result_repo.totalCasesCity(name);
		return test_result_repo.totalCasesCity(name);
	}
	
	public int totalCasesPincode(int name) {
		
		int t=test_result_repo.totalCasesPincode(name);
		
		return test_result_repo.totalCasesPincode(name);
	}
	
	public int totalTestsByHw(int hwid) {
		return test_result_repo.totalTestByHwId(hwid);
	}
	
	public List<TestResult> displayAllResults() {
		return test_result_repo.displayAll();
	}
	public int totalAllTests() {
		return test_result_repo.totalAllTest();
	}
	public int countAllPositive() {
		return test_result_repo.countAllPositive();
	}
	


}
