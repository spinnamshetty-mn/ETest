package com.example.demo;
/*
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.epidemic.EpidemicApplication;
import com.epidemic.joinclass;
import com.epidemic.model.TestRequest;
import com.epidemic.repositories.GovernmentRepo;
import com.epidemic.repositories.TestRequestRepo;
import com.epidemic.services.GovernmentService;
import com.epidemic.services.TestRequestService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= {EpidemicApplication.class})
class EpidemicTestRequestTests {
	
	@Autowired
	private TestRequestService testRequestService;
	
	@MockBean
	private TestRequestRepo testRequestRepo;
	
	@Test
	public void findTestTest() {
		TestRequest testrequest=new TestRequest(11,21);
		when(testRequestRepo.findByPatientId(testrequest.getPatientId())).thenReturn(testrequest);
		assertEquals(testrequest,testRequestService.findTest(11));
	}
	@Test
	public void addTest() {
		TestRequest testrequest=new TestRequest(11,21);
		testRequestService.add(testrequest);
		verify(testRequestRepo,times(1)).save(testrequest);
	}
	@Test
	public void displayRequestTest() {
		//TestRequest testrequest=new TestRequest(11,21);
		when(testRequestRepo.findByHwId(21)).thenReturn(Arrays.asList(new TestRequest(11,21),new TestRequest(12,21)));

	}
	@Test
	public void getInformationTest() {
		//joinclass joined=new joinclass(11,101,"srija","pinnamshetty",21);
		when(testRequestRepo.getInfo()).thenReturn(Arrays.asList(new joinclass(11,101,"srija","pinnamshetty",21),new joinclass(12,102,"srija2","pinnamshetty2",22)));
		assertEquals(2,testRequestService.getInformation().size());
	}
	@Test
	public void getInformationByIdTest() {
		int id=21;
		when(testRequestRepo.getInfo(id)).thenReturn(Arrays.asList(new joinclass(11,101,"srija","pinnamshetty",21),new joinclass(12,102,"srija2","pinnamshetty2",21)));
		assertEquals(2,testRequestService.getInformation(id).size());
	}
	@Test
	public void findRequestTest() {
		int ReportId=101;
		TestRequest testRequest=new TestRequest(11,21);
		when(testRequestRepo.findById(ReportId)).thenReturn(testRequest);
		assertEquals(testRequest,testRequestService.findRequest(ReportId));
	}
	@Test
	public void countPendingByHwTest() {
		int hwId=21;
		when(testRequestRepo.pendingByHw(hwId)).thenReturn(21);
		assertEquals(21,testRequestService.countPendingByHw(hwId));
	}
	@Test
	public void displayAllRequestTest() {
		when(testRequestRepo.displayAllRequest()).thenReturn(Arrays.asList(new TestRequest(11,21),new TestRequest(12,22)));
		assertEquals(2,testRequestService.diplayAllRequest().size());
	}
	
}
*/