package com.epidemic.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epidemic.model.ContactList;
import com.epidemic.repositories.ContactListRepo;

@Service
public class ContactListService {
	
	@Autowired
	ContactListRepo contactlist_repo;
	
	public void add(ContactList contactList) {
		if(contactPresent(contactList)==null) {
			contactlist_repo.save(contactList); // add new contact
		}
		else {
			ContactList cl=contactPresent(contactList);
			cl.setContactDate(contactList.getContactDate());    // get and update date of contact
			contactlist_repo.save(cl);
		}
		
	}
	
	public ContactList contactPresent(ContactList contactList) {
		return contactlist_repo.isPresent(contactList.getpatientId(),contactList.getMobile());
		
	}
	
	public List<ContactList> displayAll(){  ///display all contacted person
		return contactlist_repo.displayAll();
	}
}
