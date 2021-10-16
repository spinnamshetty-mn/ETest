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
import com.epidemic.UpdatedResult;
import com.epidemic.model.HealthWorker;
import com.epidemic.model.LatestResult;
import com.epidemic.model.Patient;
import com.epidemic.model.TestRequest;
import com.epidemic.model.TestResult;
import com.epidemic.repositories.GovernmentRepo;
import com.epidemic.repositories.LatestResultRepo;
import com.epidemic.repositories.PatientRepo;
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
	
	@MockBean
	private PatientRepo patientRepo;
	
	@Test
	public void addTest() {
		Date date1=new Date(12-9-1999);
		TestResult testResult=new TestResult(11,101,21,"positive",date1,"nagar","telanagan",500001,"corona","pcr");
		TestRequest tr=new TestRequest(11,21,"corona","pcr");
		Patient p=new Patient("srija","pinnamshetty","srija@gmail.com","Modeln-123","9090909090","nagar","telangana",500001);
		when(testRequestRepo.findById(101)).thenReturn(tr);
		when(patientRepo.findById(11)).thenReturn(p);
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
		l.add(new TestResult(11,101,21,"positive",date1,"nagar","telanagan",500001,"corona","pcr"));
		l.add(new TestResult(11,102,22,"positive",date1,"nagar2","telanagana2",500002,"corona","rt-pcr"));
		when(testResultRepo.findAllByPatient(11)).thenReturn(l);	
		assertEquals(2,testResultService.findAllPatientResult(pat_id).size());
	} 
	/*
	@Test
	public void findByPatientTest() {
		int pat_id=11;
		TestResult testResult=new TestResult(11,101,21,"posotive","nagar","telangana",500001,"corona","pcr");
		when(testResultRepo.findByPatient(pat_id)).thenReturn(101);
		testResultService.findByPatient(11);
		verify(testResultRepo,times(1)).findByPatient(pat_id);
	}*/
	
	@Test
	public void findAllResultsByHWTest() {
		int hwId=21;
		Date d=new Date();
		when(testResultRepo.findByOrderByHwIdDesc(hwId)).thenReturn(Arrays.asList(new UpdatedResult(11,101,"srija","pinnamshetty","positive",d,500001,"corona","pcr"),new UpdatedResult(12,102,"srija","pinnamshetty","positive",d,500001,"corona","rt-pcr")));
		assertEquals(2,testResultService.findAllResultsByHW(hwId).size());
	}
	
	@Test
	public void getAllStateTest() {
		when(testResultRepo.findByState()).thenReturn(Arrays.asList("telangana","andhra_pradesh"));	
		assertEquals(2,testResultService.getAllState().size());
	}
	
	@Test
	public void getAllCityTest() {
		when(testResultRepo.findByCity()).thenReturn(Arrays.asList("nagar","allahabad"));	
		assertEquals(2,testResultService.getAllCity().size());
	}
	
	@Test
	public void getAllPincodeTest() {
		when(testResultRepo.findByPincode()).thenReturn(Arrays.asList("500001","500002"));	
		assertEquals(2,testResultService.getAllPincode().size());
	}
	
	
	@Test
	public void  totalTestStateTest() {
		String state="telangana";
		String diseaseType="corona";
		when(testResultRepo.totalTestState(state,diseaseType)).thenReturn(20);
		assertEquals(20,testResultService.totalTestState("telangana","corona"));
	}
	
	@Test
	public void  totalTestCityTest() {
		String city="nagar";
		String diseaseType="corona";
		when(testResultRepo.totalTestCity(city,diseaseType)).thenReturn(20);
		assertEquals(20,testResultService.totalTestCity("nagar","corona"));
	}
	
	@Test
	public void totalTestPincodeTest()
	{
		int pin=500001;
		String diseaseType="corona";
		when(testResultRepo.totalTestPincode(pin,diseaseType)).thenReturn(20);
		assertEquals(20,testResultService.totalTestPincode(500001,"corona"));
	}
	
	@Test
	public void totalCasesStateTest()
	{
		String state="telangana";
		String diseaseType="corona";
		when(testResultRepo.totalCasesCity(state,diseaseType)).thenReturn(3);
		assertEquals(3,testResultService.totalCasesCity("telangana","corona"));
	}
	
	@Test
	public void totalCasesCityTest()
	{
		String city="nagar";
		String diseaseType="corona";
		when(testResultRepo.totalCasesCity(city,diseaseType)).thenReturn(3);
		assertEquals(3,testResultService.totalCasesCity("nagar","corona"));
	}
	
	@Test
	public void totalCasesPincodeTest()
	{
		int pin=500001;
		String diseaseType="corona";
		when(testResultRepo.totalCasesPincode(pin,diseaseType)).thenReturn(3);
		assertEquals(3,testResultService.totalCasesPincode(500001,"corona"));
	}
	
	@Test
	public void totalTestsByHwTest() {
		int hwid=21;
		String diseaseType="corona";
		when(testResultRepo.totalTestByHwId(hwid,diseaseType)).thenReturn(2);
		assertEquals(2,testResultService.totalTestsByHw(21,"corona"));
	}
	
	@Test
	public void displayAllResultsTest() {
		Date d=new Date();
		when(testResultRepo.displayAll()).thenReturn(Arrays.asList(new TestResult(11,101,21,"positive",d,"nagar","telangana",500001,"corona","pcr"),new TestResult(12,102,22,"positive",d,"nagar2","telangana",500003,"corona","pcr")));
		assertEquals(2,testResultService.displayAllResults().size());
	}
	
	@Test
	public void displayAllResultsByStateTest() {
		Date d=new Date();
		String state="telangana";
		when(testResultRepo.displayAll(state)).thenReturn(Arrays.asList(new TestResult(11,101,21,"positive",d,"nagar","telangana",500001,"corona","pcr"),new TestResult(12,102,22,"positive",d,"nagar2","telangana",500003,"corona","pcr")));
		assertEquals(2,testResultService.displayAllResults("telangana").size());
	}
	
	@Test
	public void totalAllTestsTest()
	{
		String diseaseType="corona";
		when(testResultRepo.countAllTest(diseaseType)).thenReturn(3);
		assertEquals(3,testResultService.totalAllTests("corona"));
	}
	
	@Test
	public void countAllPositiveTest()
	{
		String diseaseType="corona";
		when(testResultRepo.countAllPositive(diseaseType)).thenReturn(3);
		assertEquals(3,testResultService.countAllPositive("corona"));
	}
	
	
}
