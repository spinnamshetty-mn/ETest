package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.epidemic.EpidemicApplication;
import com.epidemic.model.HealthWorker;
import com.epidemic.model.LatestResult;
import com.epidemic.model.Patient;
import com.epidemic.model.TestRequest;
import com.epidemic.model.TestResult;
import com.epidemic.repositories.GovernmentRepo;
import com.epidemic.repositories.LatestResultRepo;
import com.epidemic.repositories.TestRequestRepo;
import com.epidemic.repositories.TestResultRepo;
import com.epidemic.services.GovernmentService;
import com.epidemic.services.PatientService;
import com.epidemic.services.TestRequestService;
import com.epidemic.services.TestResultService;
import java.util.*;
//import java.util.List;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= {EpidemicApplication.class})
class EpidemicTestResultTests {
	@Autowired
	private TestResultService testResultService;
	
	@Autowired
	private TestRequestService testRequestService;
	
	@Autowired
	private PatientService patientService;
	
	@MockBean
	private TestResultRepo testResultRepo;
	
	@MockBean
	private TestRequestRepo testRequestRepo;
	
	@MockBean
	private LatestResultRepo latestResultRepo;
	
	@Test
	public void addTest() {
		Date date1=new Date(12-9-1999);
		TestResult testResult=new TestResult(11,101,21,"positive",date1,"nagar","telanagan",500001);
		TestRequest tr=new TestRequest(11,21);
		when(testRequestRepo.findById(101)).thenReturn(tr);
		when(testResultRepo.findByReportId(101)).thenReturn(testResult);
		testResultService.add(101, "positive");
		verify(testRequestRepo,times(1)).delete(tr);
		verify(testResultRepo,times(1)).findByReportId(101);
		verify(testResultRepo,times(1)).findByDate(101);
	}

	@Test
	public void findAllPatientResultTest() {
		int pat_id=11;
		Date date1=new Date(12-9-1999);
		List<TestResult> l=new ArrayList<TestResult>();
		l.add(new TestResult(11,101,21,"positive",date1,"nagar","telanagan",500001));
		l.add(new TestResult(11,102,22,"positive",date1,"nagar2","telanagana2",500002));
		when(testResultRepo.findAllByPatient(11)).thenReturn(l);	
		assertEquals(2,testResultService.findAllPatientResult(pat_id).size());
	} 
	/*@Test
	public void findByPatientTest() {
		int pat_id=11;
		TestResult testResult=new TestResult(11,101,21,"posotive","nagar","telangana",500001);
		when(testResultRepo.findByPatient(pat_id)).thenReturn(101);
		testResultService.findByPatient(11);
		verify(testResultRepo,times(1)).findByPatient(pat_id);
	}
	*/
	@Test
	public void findAllResultsByHWTest() {
		int hwId=21;
		when(testResultRepo.findByOrderByHwIdDesc(hwId)).thenReturn(Arrays.asList(new TestResult(11,101,21,"posotive",new Date(18-9-2021),"nagar","telangana",500001),new TestResult(12,102,21,"positive",new Date(14-8-2020),"warang","andhra",500002)));
		assertEquals(2,testResultService.findAllResultsByHW(hwId).size());
	}
	
	
	
	@Test
	public void getAllStateTest() {
		List<String> l=new ArrayList<String>();
		l.add("telangana");
		l.add("andhra_pradesh");
		l.add("uttar_pradesh");
		when(testResultRepo.findByState()).thenReturn(l);	
		assertEquals(3,testResultService.getAllState().size());
	}
	
	@Test
	public void getAllCityTest() {
		List<String> l=new ArrayList<String>();
		l.add("nagar");
		l.add("warangal");
		l.add("allahabad");
		when(testResultRepo.findByCity()).thenReturn(l);	
		assertEquals(3,testResultService.getAllCity().size());
	}
	
	@Test
	public void getAllPincodeTest() {
		List<String> l=new ArrayList<String>();
		l.add("509001");
		l.add("500034");
		l.add("200567");
		when(testResultRepo.findByPincode()).thenReturn(l);	
		assertEquals(3,testResultService.getAllPincode().size());
	}
	
	
	@Test
	public void  totalTestStateTest() {
		String state="telangana";
		when(testResultRepo.totalTestState(state)).thenReturn(20);
		assertEquals(20,testResultService.totalTestState(state));
	}
	
	@Test
	public void  totalTestCityTest() {
		String city="nagar";
		when(testResultRepo.totalTestCity(city)).thenReturn(20);
		assertEquals(20,testResultService.totalTestCity(city));
	}
	
	@Test
	public void totalTestPincodeTest()
	{
		int pin=500001;
		when(testResultRepo.totalTestPincode(pin)).thenReturn(20);
		assertEquals(20,testResultService.totalTestPincode(pin));
	}
	
	@Test
	public void totalCasesStateTest()
	{
		String state="telangana";
		when(testResultRepo.totalCasesCity(state)).thenReturn(3);
		assertEquals(3,testResultService.totalCasesCity(state));
	}
	
	@Test
	public void totalCasesCityTest()
	{
		String city="nagar";
		when(testResultRepo.totalCasesCity(city)).thenReturn(3);
		assertEquals(3,testResultService.totalCasesCity(city));
	}
	
	@Test
	public void totalCasesPincodeTest()
	{
		int pin=500001;
		when(testResultRepo.totalCasesPincode(pin)).thenReturn(3);
		assertEquals(3,testResultService.totalCasesPincode(pin));
	}
	
	@Test
	public void totalTestsByHwTest() {
		int hwid=21;
		when(testResultRepo.totalTestByHwId(hwid)).thenReturn(2);
		assertEquals(2,testResultService.totalTestsByHw(hwid));
	}
}
