package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.epidemic.EpidemicApplication;
import com.epidemic.model.Patient;
import com.epidemic.repositories.PatientRepo;
import com.epidemic.services.PatientService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= {EpidemicApplication.class})
class EpidemicPatientTests {

	@Autowired
	private PatientService patientService;
	
	@MockBean
	private PatientRepo patientRepo;
	
	@Test
	public void addPatientTest()
	{
		Patient patient=new Patient("srija","pinnamshetty","srija@gmail.com","Modeln-123","9898989898","nagarkurnool","telangana",509102);
		patientService.addPatient(patient);
		verify(patientRepo,times(1)).save(patient);
	}
	@Test
	public void searchPatientTestByPatient() 
	{
			 Patient patient=new Patient("srija","pinnamshetty","srija@gmail.com","Modeln-123","9898989898","nagarkurnool","telangana",509102);
			 when(patientRepo.findByEmail(patient.getEmail())).thenReturn(patient);
			 assertEquals(patient,patientService.searchPatient(patient));
	}
	@Test
	public void searchPatientTestByEmail() 
	{
			 Patient patient=new Patient("srija","pinnamshetty","srija@gmail.com","Modeln-123","9898989898","nagarkurnool","telangana",509102); 
			 String email="srija@gmail.com";
			 when(patientRepo.findByEmail(email)).thenReturn(patient);
			 assertEquals(patient,patientService.searchPatient(email));
	}
	@Test
	public void searchPatientTestById() 
	{
			 Patient patient=new Patient("srija","pinnamshetty","srija@gmail.com","Modeln-123","9898989898","nagarkurnool","telangana",509102); 
			 int id=1;
			 when(patientRepo.findById(id)).thenReturn(patient);
			 assertEquals(patient,patientService.searchPatient(id));
	}
	@Test
	public void validateTest()
	{
		Patient patient=new Patient("srija","pinnamshetty","srija@gmail.com","Modeln-123","9898989898","nagarkurnool","telangana",509102);
		patientService.validate(patient.getEmail(),patient.getPassword());
		verify(patientRepo,times(1)).findByEmail(patient.getEmail());
	}
	
}
