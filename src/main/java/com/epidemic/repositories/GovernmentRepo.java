package com.epidemic.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.epidemic.model.Government;
import java.util.*;

public interface GovernmentRepo extends CrudRepository<Government,Integer> {
	Government findByEmail(String email);
	Government findByGovId(int govId);
	
	@Query(value="select * from government g where g.status='pending' ",nativeQuery=true)
	List<Government> getPendingRequests();
}
