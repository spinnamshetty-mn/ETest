package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.epidemic.EpidemicApplication;
import com.epidemic.model.TestRequest;
import com.epidemic.model.TestResult;
import com.epidemic.repositories.TestRequestRepo;
import com.epidemic.repositories.TestResultRepo;
import com.epidemic.services.TestRequestService;
import com.epidemic.services.TestResultService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= {EpidemicApplication.class})
class EndToEnd {

	
	//test request
	//update test result
	//view test result (by patient)

	@Autowired
	private TestRequestService testRequestService;
	
	@MockBean
	private TestRequestRepo testRequestRepo;
	
	@MockBean
	private TestResultRepo testResultRepo;
	
	@Autowired
	private TestResultService testResultService;
	
	TestRequest testrequest=new TestRequest(11,21,"corona","pcr");
	Date date=new Date(12-9-1999);
	TestResult testResult=new TestResult(11,101,21,"positive",date,"nagar","telanagan",500001,"corona","pcr");
	int pat_id=11;
	
	
	@RepeatedTest(10)
	void endToEndTesting() {
		
		testRequestService.add(testrequest);
		verify(testRequestRepo,times(1)).save(testrequest);
		
		when(testRequestRepo.findById(101)).thenReturn(testrequest);
		when(testResultRepo.findByReportId(101)).thenReturn(testResult);
		testResultService.add(101, "positive");
		verify(testRequestRepo,times(1)).delete(testrequest);
		verify(testResultRepo,times(1)).findByReportId(101);
		verify(testResultRepo,times(1)).findByDate(101);
		
		List<TestResult> l=new ArrayList<TestResult>();
		l.add(new TestResult(11,101,21,"positive",date,"nagar","telanagan",500001,"corona","pcr"));
		when(testResultRepo.findAllByPatient(11)).thenReturn(l);	
		assertEquals(1,testResultService.findAllPatientResult(pat_id).size());
		
	}

}
