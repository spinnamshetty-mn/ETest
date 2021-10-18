package com.epidemic.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.epidemic.model.LatestResult;

public interface LatestResultRepo extends CrudRepository<LatestResult,Integer>{
	
//------------------------------------count current active by type--------------------
	@Query(value="select count(*) from latestresult lr where lr.state= :str and lr.status='positive' ",nativeQuery=true)
	int getCountByState(@Param("str") String str);
	
	@Query(value="select count(*) from latestresult lr where lr.city= :str and lr.status='positive' ",nativeQuery=true)
	int getCountByCity(@Param("str") String str);
	
	@Query(value="select count(*) from latestresult lr where lr.pincode= :str and lr.status='positive' ",nativeQuery=true)
	int getCountByPincode(@Param("str") int str);
	
	@Query(value="select count(*) from latestresult lr where lr.hw_id= :hwid and lr.status='positive' ",nativeQuery=true)
	int getCountByHwId(@Param("hwid") int hwid);
	
	@Query(value="select count(*) from latestresult lr where lr.status='positive' ",nativeQuery=true)
	int countAllActive();
	
	@Query(value="select count(*) from latestresult lr where lr.hw_id= :hwid and lr.disease_type=:diseaseType  and lr.status='positive' ",nativeQuery=true)
	int getCountByHwId(@Param("hwid") int hwid,@Param("diseaseType") String diseaseType);
	
	@Query(value="select count(*) from latestresult lr where lr.state= :state and lr.disease_type=:diseaseType and lr.status='positive' ",nativeQuery=true)
	int getCountByState(@Param("state") String state, @Param("diseaseType") String diseaseType);
	
	@Query(value="select count(*) from latestresult lr where lr.city= :str and lr.disease_type=:diseaseType and lr.status='positive'",nativeQuery=true)
	int getCountByCity(@Param("str") String str, @Param("diseaseType") String diseaseType);
	
	@Query(value="select count(*) from latestresult lr where lr.pincode= :str and lr.disease_type=:diseaseType and lr.status='positive'",nativeQuery=true)
	int getCountByPincode(@Param("str") int str, @Param("diseaseType") String diseaseType);
	
	@Query(value="select count(*) from latestresult lr where lr.status='positive' and lr.disease_type=:diseaseType ",nativeQuery=true)
	int countAllActive(@Param("diseaseType") String diseaseType);
//------------------------------------find latest result of patient by type----------------------------------------
	@Query(value="select distinct(tr.state) from latestresult tr",nativeQuery=true)
	List<String> findByState();
	
	@Query(value="select lr.status from latestresult lr where lr.patient_id= :id",nativeQuery=true)
	String findLatestResult(@Param("id") int id);

	@Query(value="select lr.result_date from latestresult lr where lr.patient_id= :id",nativeQuery=true)
	Date findLatestDate(@Param("id")int id);
	
	@Query(value="select * from latestresult lr where lr.patient_id= :id",nativeQuery=true)
	LatestResult findLatestResultPatient(@Param("id") int id);
	
	@Query(value="select * from latestresult lr where lr.status='positive' and lr.state=:state order by lr.result_date desc",nativeQuery=true)
	List<LatestResult> findAllActiveCases(@Param("state") String state);

	@Query(value="select * from latestresult lr where lr.patient_id= :patientId and lr.disease_type=:diseaseType",nativeQuery=true)
	LatestResult findLatestResultPatient(@Param("patientId") int patientId,@Param("diseaseType") String diseaseType);

	@Query(value="select * from latestresult lr where lr.patient_id= :patientId",nativeQuery=true)
	List<LatestResult> getLatestResultList(@Param("patientId")int patientId);

	@Query(value="select * from latestresult lr where lr.status='positive' order by lr.result_date desc",nativeQuery=true)
	List<LatestResult> findAllActiveCases();

	
	

	
	

	
	

	
	
	
	
	
}
