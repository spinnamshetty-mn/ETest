package com.epidemic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.epidemic.model.ContactList;

public interface ContactListRepo extends CrudRepository<ContactList,Long> {

	ContactList findByMobile(long mobile);
	
	@Query(value="select * from contactlist cl order by cl.contact_date desc",nativeQuery=true)
	List<ContactList> displayAll();   // list of  all contactsresult
	
	@Query(value="select * from contactlist cl where cl.patient_id= :patientId and cl.mobile= :mobile ",nativeQuery=true)
	ContactList isPresent(@Param("patientId") int patientId,@Param("mobile") long mobile); // to check if same has entered a same contact

}

