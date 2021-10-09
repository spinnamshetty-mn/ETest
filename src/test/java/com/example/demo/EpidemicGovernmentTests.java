package com.example.demo;

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
import com.epidemic.model.Government;
import com.epidemic.model.HealthWorker;
import com.epidemic.repositories.GovernmentRepo;
import com.epidemic.repositories.PatientRepo;
import com.epidemic.services.GovernmentService;
import com.epidemic.services.PatientService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= {EpidemicApplication.class})
class EpidemicGovernmentTests {

	@Autowired
	private GovernmentService governmentService;
	
	@MockBean
	private GovernmentRepo governmentRepo;
	
	@Test
	public void addGovTest()
	{
		Government government=new Government("gov@gmail.com","Modeln-123","telangana");
		governmentService.addGov(government);
		verify(governmentRepo,times(1)).save(government);
	}
	
	@Test
	public void searchGovTestByGov()
	{
		Government government=new Government("gov@gmail.com","Modeln-123","telangana");
		String email="gov@gmail.com";
		when(governmentRepo.findByEmail(email)).thenReturn(government);
		assertEquals(government,governmentService.searchGov(government));
	}
	
	@Test
	public void searchGovTestByEmail()
	{
		Government government=new Government("gov@gmail.com","Modeln-123","telangana");
		String email="gov@gmail.com";
		when(governmentRepo.findByEmail(email)).thenReturn(government);
		assertEquals(government,governmentService.searchGov(email));
	}
	@Test
	public void searchGovTestById()
	{
		Government government=new Government("gov@gmail.com","Modeln-123","telangana");
		government.setGovId(1);
		int id=government.getGovId();
		when(governmentRepo.findByGovId(1)).thenReturn(government);
		assertEquals(government,governmentService.searchGov(id));
	}
	
	@Test
	public void validateTest()
	{
		Government government=new Government("gov@gmail.com","Modeln-123","telangana");
		governmentService.validate(government.getEmail(),government.getPassword());
		verify(governmentRepo,times(1)).findByEmail(government.getEmail());
	}
	
	@Test
	public void updateTest()
	{
		Government government=new Government("gov@gmail.com","Modeln-123","telangana");
		governmentService.Update(government);
		verify(governmentRepo,times(1)).save(government);
	}
	
	@Test
	public void getPendingRequestsTest() {
		when(governmentRepo.getPendingRequests()).thenReturn(Arrays.asList(new Government("gov@gmail.com","Modeln-123","telangana"),new Government("gov2@gmail.com","Modeln-123","up")));
		assertEquals(2,governmentService.getPendingRequests().size());
	}
	
	@Test
	public void deleteRequestTest() {
		int id=2;
		governmentService.deleteRequest(id);
		verify(governmentRepo,times(1)).deleteById(2);
	}
	
	@Test
	public void updateRequestTest() {
		int id=2;
		Government government=new Government("gov@gmail.com","Modeln-123","telangana");
		when(governmentRepo.findByGovId(id)).thenReturn(government);
		governmentService.updateRequest(id);
		verify(governmentRepo,times(1)).save(government);
	}
	
}
