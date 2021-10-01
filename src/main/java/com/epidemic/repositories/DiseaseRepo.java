package com.epidemic.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.epidemic.*;
import com.epidemic.model.Disease;
import java.util.*;

public interface DiseaseRepo extends CrudRepository<Disease,Integer> {

	@Query
	(value="select * from epidemic",nativeQuery=true)
	String findAllDisease();
	
	
}
