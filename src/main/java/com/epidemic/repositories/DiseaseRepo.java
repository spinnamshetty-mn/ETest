package com.epidemic.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.epidemic.*;
import com.epidemic.model.Disease;
import java.util.*;

public interface DiseaseRepo extends CrudRepository<Disease,Integer> {

	@Query
	(value="select * from epidemic",nativeQuery=true)
	String findAllDisease();

	@Query(value="select * from epidemic e where e.disease=:diseaseType",nativeQuery=true)
	Disease findDisease(@Param("diseaseType") String diseaseType);
	
	@Query(value="select distinct(e.disease) from epidemic e",nativeQuery=true)
	List<String> findAllDiseases();

	@Query(value="select * from epidemic e where e.disease=:disease and e.test=:test",nativeQuery=true)
	Disease isPresent(@Param("disease") String disease,@Param("test") String test);
	
}
