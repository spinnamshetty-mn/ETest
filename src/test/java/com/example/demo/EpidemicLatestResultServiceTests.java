package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;



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
import java.util.*;

import com.epidemic.EpidemicApplication;
import com.epidemic.model.LatestResult;
import com.epidemic.repositories.GovernmentRepo;
import com.epidemic.repositories.LatestResultRepo;
import com.epidemic.services.GovernmentService;
import com.epidemic.services.LatestResultService;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= {EpidemicApplication.class})
class EpidemicLatestResultServiceTests {

	@Autowired
	private LatestResultService latestResultService;
	@MockBean
	private LatestResultRepo latestResultRepo;
	
	
	@Test
	public void countActiveByStateTest() {
		String state="telangana",diseaseType="corona";
		when(latestResultRepo.getCountByState(state,diseaseType)).thenReturn(1);
		assertEquals(1,latestResultService.countActiveByState("telangana","corona"));
	}
	@Test
	public void countActiveByCityTest() {
		String city="hyderabad",diseaseType="corona";
		when(latestResultRepo.getCountByCity(city,diseaseType)).thenReturn(1);
		assertEquals(1,latestResultService.countActiveByCity("hyderabad","corona"));
	}
	@Test
	public void CountActiveByPincodeTest() {
		int pincode=500001;
		String diseaseType="corona";
		when(latestResultRepo.getCountByPincode(pincode,diseaseType)).thenReturn(1);
		assertEquals(1,latestResultService.CountActiveByPincode(500001,"corona"));
	}
	
	@Test
	public void getAllStateTest() {
		when(latestResultRepo.findByState()).thenReturn(Arrays.asList("tel","up","mp"));
		assertEquals(3,latestResultService. getAllState().size());
	}
	
	@Test
	public void getLatestResultTest()
	{
		int id=11;
		when(latestResultRepo.findLatestResult(id)).thenReturn("positive");
		assertEquals("positive",latestResultService.getLatestResult(11));
	}
	
	@Test
	public void getLatestDateTest()
	{
		Date date=new Date(1-1-1970);
		int id=11;
		when(latestResultRepo.findLatestDate(id)).thenReturn(date);
		assertEquals(date,latestResultService.getLatestDate(11));
	}
	
	@Test
	public void getLatestResultPatientTest()
	{
		int id=11;
		Date d=new Date();
		String diseaseType="corona";
		LatestResult latestResult=new LatestResult(11,101,21,"positive",d,"nagar","tel",500001,"corona","pcr");
		when(latestResultRepo.findLatestResultPatient(id,diseaseType)).thenReturn(latestResult);
		assertEquals(latestResult,latestResultService.getLatestResultPatient(11,"corona"));
	}
	
	@Test
	public void getCountByHwIdTest()
	{
		int hw_id=11;
		String diseaseType="corona";
		when(latestResultRepo.getCountByHwId(hw_id,diseaseType)).thenReturn(5);
		assertEquals(5,latestResultService.getCountByHwId(11,"corona"));
	}
	
	@Test
	public void getCountAllActiveCasesTest() {
		String diseaseType="corona";
		when(latestResultRepo.countAllActive(diseaseType)).thenReturn(5);
		assertEquals(5,latestResultService.getCountAllActiveCases("corona"));
	}
	
	@Test
	public void displayActiveCasesByStateTest() {
		String state="telangana";
		when(latestResultRepo.findAllActiveCases(state)).thenReturn(Arrays.asList(new LatestResult(11,101,21,"positive",new Date(19-9-2020),"nagar","tel",500001,"corona","pcr"), new LatestResult(12,102,22,"positive",new Date(19-9-2019),"nagar2","tel2",500002,"corona","rt-pcr")));
		assertEquals(2,latestResultService.displayActiveCases("telangana").size());
	}
	
	@Test
	public void getLatestResultPatientListTest() {
		int patient_id=11;
		when(latestResultRepo.getLatestResultList(patient_id)).thenReturn(Arrays.asList(new LatestResult(11,101,21,"positive",new Date(19-9-2020),"nagar","tel",500001,"corona","pcr"), new LatestResult(11,102,22,"positive",new Date(19-9-2019),"nagar2","tel2",500002,"corona","rt-pcr")));
		assertEquals(2,latestResultService.getLatestResultPatientList(11).size());
	}
	
	@Test
	public void displayActiveCasesTest() {
		when(latestResultRepo.findAllActiveCases()).thenReturn(Arrays.asList(new LatestResult(11,101,21,"positive",new Date(19-9-2020),"nagar","tel",500001,"corona","pcr"), new LatestResult(12,102,22,"positive",new Date(19-9-2019),"nagar2","tel2",500002,"corona","rt-pcr")));
		assertEquals(2,latestResultService.displayActiveCases().size());
	}
}

