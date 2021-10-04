package com.example.demo;
/*
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.*;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.epidemic.EpidemicApplication;
import com.epidemic.model.HealthWorker;
import com.epidemic.model.Patient;
import com.epidemic.repositories.HealthWorkerRepo;
import com.epidemic.repositories.PatientRepo;
import com.epidemic.services.HealthWorkerService;
import com.epidemic.services.PatientService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= {EpidemicApplication.class})
class EpidemicHealthWorkersTests {

	@Autowired
	private HealthWorkerService healthWorkerService;
	
	@MockBean
	private HealthWorkerRepo healthWorkerRepo;
	
	@Test
	public void addHealthWorkerTest()
	{
		HealthWorker healthworker=new HealthWorker("srija","hyderabad","srija@gmail.com","Modeln-123","9898989898","doctor","approved");
		healthWorkerService.addWorker(healthworker);
		verify(healthWorkerRepo,times(1)).save(healthworker);
	}
	
	@Test
	public void searchHealthWorkerTestByHealthWorker() 
	{
			HealthWorker healthworker=new HealthWorker("srija","hyderabad","srija@gmail.com","Modeln-123","9898989898","doctor","approved");
			 when(healthWorkerRepo.findByEmail(healthworker.getEmail())).thenReturn(healthworker);
			 assertEquals(healthworker,healthWorkerService.searchWorker(healthworker));
	}
	@Test
	public void searchHealthWorkerTestById() 
	{
			HealthWorker healthworker=new HealthWorker("srija","hyderabad","srija@gmail.com","Modeln-123","9898989898","doctor","approved");
			int id=1;
			when(healthWorkerRepo.findById(id)).thenReturn(healthworker);
			assertEquals(healthworker,healthWorkerService.searchWorker(id));
	}
	@Test
	public void searchHealthWorkerTestByEmail() 
	{
			HealthWorker healthworker=new HealthWorker("srija","hyderabad","srija@gmail.com","Modeln-123","9898989898","doctor","approved");
			String email="srija@gmail.com";
			when(healthWorkerRepo.findByEmail(email)).thenReturn(healthworker);
			assertEquals(healthworker,healthWorkerService.searchWorker(email));
	}
	@Test
	public void validateTest()
	{
		HealthWorker healthworker=new HealthWorker("srija","hyderabad","srija@gmail.com","Modeln-123","9898989898","doctor","approved");
		healthWorkerService.validate(healthworker.getEmail(),healthworker.getPassword());
		verify(healthWorkerRepo,times(1)).findByEmail(healthworker.getEmail());
	}
	@Test
	public void updateRequestTest() {
		HealthWorker healthworker=new HealthWorker("srija","hyderabad","srija@gmail.com","Modeln-123","9898989898","doctor","pending");
		healthworker.setId(1);
		when(healthWorkerRepo.findById(1)).thenReturn(healthworker);
		healthWorkerService.updateRequest(1);
		verify(healthWorkerRepo,times(1)).findById(1);
		verify(healthWorkerRepo,times(1)).save(healthworker);
	}
	@Test
	public void deleteRequestTest(){
		HealthWorker healthworker=new HealthWorker("srija","hyderabad","srija@gmail.com","Modeln-123","9898989898","doctor","pending");
		healthworker.setId(1);
		healthWorkerService.deleteRequest(1);
		verify(healthWorkerRepo,times(1)).deleteById(1);
	}
	
	@Test
	public void findActiveHWTest() {
		when(healthWorkerRepo.findByActiveHw()).thenReturn(Arrays.asList(new HealthWorker("srija","hyderabad","srija@gmail.com","Modeln-123","9898989898","doctor","approved"),new HealthWorker("srij","hyderaba","srij@gmail.com","Model-123","9898989899","doctor","approved")));
		assertEquals(2,healthWorkerService.findActiveHW().size());
	}
	
	@Test
	public void displayAllHWTest() {
		when(healthWorkerRepo.findAllHW()).thenReturn(Arrays.asList(new HealthWorker("srija","hyderabad","srija@gmail.com","Modeln-123","9898989898","doctor","approved"),new HealthWorker("srij","hyderaba","srij@gmail.com","Model-123","9898989899","doctor","approved")));
		assertEquals(2,healthWorkerService.displayAllHW().size());
	}
	@Test
	public void displayPendingHWTest() {
		when(healthWorkerRepo.findAllPendingHw()).thenReturn(Arrays.asList(new HealthWorker("srija","hyderabad","srija@gmail.com","Modeln-123","9898989898","doctor","approved"),new HealthWorker("srij","hyderaba","srij@gmail.com","Model-123","9898989899","doctor","approved")));
		assertEquals(2,healthWorkerService.displayPendingHW().size());
	}
	@Test
	public void updateTest()
	{
		HealthWorker healthworker=new HealthWorker("srija","hyderabad","srija@gmail.com","Modeln-123","9898989898","doctor","approved");
		healthWorkerService.update(healthworker);
		verify(healthWorkerRepo,times(1)).save(healthworker);
	}

}
*/