package com.example.demo;
/*
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
		String state="telangana";
		when(latestResultRepo.getCountByState(state)).thenReturn(1);
		assertEquals(1,latestResultService.countActiveByState("telangana"));
	}
	@Test
	public void countActiveByCityTest() {
		String city="hyderabad";
		when(latestResultRepo.getCountByCity(city)).thenReturn(1);
		assertEquals(1,latestResultService.countActiveByCity("hyderabad"));
	}
	@Test
	public void CountActiveByPincodeTest() {
		int pincode=500001;
		when(latestResultRepo.getCountByPincode(pincode)).thenReturn(1);
		assertEquals(1,latestResultService.CountActiveByPincode(500001));
	}
	
	@Test
	public void getAllStateTest() {
		List<String> ls=new ArrayList<String>();
		ls.add("tel");
		ls.add("up");
		ls.add("mp");
		when(latestResultRepo.findByState()).thenReturn(ls);
		assertEquals(ls,latestResultService. getAllState());
	}
	
	@Test
	public void getLatestResultTest()
	{
		int id=11;
		when(latestResultRepo.findLatestResult(id)).thenReturn("positive");
		assertEquals("positive",latestResultService.getLatestResult(id));
	}
	
	@Test
	public void getLatestDateTest()
	{
		Date date=new Date(1-1-1970);
		int id=11;
		when(latestResultRepo.findLatestDate(id)).thenReturn(date);
		assertEquals(date,latestResultService.getLatestDate(id));
	}
	/*
	@Test
	public void getLatestResultPatientTest()
	{
		int id=11;
		LatestResult latestResult=new LatestResult(1,11,101,21,"positive",new Date(19-9-2020),"nagar","tel",500001);
		when(latestResultRepo.findLatestResultPatient(id)).thenReturn(latestResult);
		assertEquals(latestResult,latestResultService.getLatestResultPatient(id));
	}
	
	@Test
	public void getCountByHwIdTest()
	{
		int hw_id=11;
		when(latestResultRepo.getCountByHwId(hw_id)).thenReturn(5);
		assertEquals(5,latestResultService.getCountByHwId(hw_id));
	}
	
	@Test
	public void getCountAllActiveCasesTest() {
		when(latestResultRepo.countAllActive()).thenReturn(5);
		assertEquals(5,latestResultService.getCountAllActiveCases());
	}
	
	@Test
	public void displayActiveCasesTest() {
		when(latestResultRepo.findAllActiveCases()).thenReturn(Arrays.asList(new LatestResult(1,11,101,21,"positive",new Date(19-9-2020),"nagar","tel",500001), new LatestResult(2,12,102,22,"positive",new Date(19-9-2019),"nagar2","tel2",500002)));
		assertEquals(2,latestResultService.displayActiveCases().size());
	}
	
	
}
*/
