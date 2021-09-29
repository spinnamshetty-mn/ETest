package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.epidemic.EpidemicApplication;
import com.epidemic.model.ContactList;
import com.epidemic.repositories.ContactListRepo;
import com.epidemic.repositories.GovernmentRepo;
import com.epidemic.services.ContactListService;
import com.epidemic.services.GovernmentService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= {EpidemicApplication.class})
class EpidemicContactListTests {

	@Autowired
	private ContactListService contactListService;
	
	@MockBean
	private ContactListRepo contactListRepo;
	
	@Test
	public void addTest() {
		Date d=new Date();
		long mobile=Long.parseLong("9345678231");
		ContactList contactList=new ContactList(11,"srija","nagar","telangana",500001,mobile,d);
		contactListService.add(contactList);
		verify(contactListRepo,times(1)).save(contactList);
	}
	
	@Test
	public void contactPresentTest()
	{
		Date d=new Date();
		long mobile=Long.parseLong("9345678231");
		ContactList contactList=new ContactList(11,"srija","nagar","telangana",500001,mobile,d);
		when(contactListRepo.isPresent(contactList.getpatientId(),contactList.getMobile())).thenReturn(contactList);
		assertEquals(contactList,contactListService.contactPresent(contactList));
	}
	
	@Test
	public void displayAllTest()
	{
		List<ContactList> list=new ArrayList<ContactList>();
		Date d=new Date();
		long mobile=Long.parseLong("9345678231");
		list.add(new ContactList(11,"srija","nagar","telangana",500001,mobile,d));
		list.add(new ContactList(12,"srija2","nagar2","telangana2",500002,mobile,d));
		when(contactListRepo.displayAll()).thenReturn(list);
		assertEquals(list,contactListService.displayAll());
	}

}
