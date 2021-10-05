package com.epidemic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.epidemic.joinclass;
import com.epidemic.model.TestRequest;

public interface TestRequestRepo extends CrudRepository<TestRequest,Long> {

	TestRequest findById(long report_id);
	
	//@Query(value="select * from testrequest tr where tr.patient_id=7",nativeQuery=true)
	TestRequest findByPatientId(int patientId);
	
	@Query
	(value="select * from testrequest where patient_id=:id and disease_type=:diseaseType",nativeQuery=true)
	TestRequest findIfPresent(@Param("id") int id,@Param("diseaseType") String diseaseType);
	
	//@Query(" select new com.epidemic.joinclass(t.patient_id, t.report_id, p.name) from testrequest t join t.Patient p ")
	List<TestRequest> findByHwId(int hwId); 
	
	@Query(" SELECT new com.epidemic.joinclass(t.patientId, t.id, p.firstName ,p.lastName , t.hwId,t.diseaseType, t.testType) FROM TestRequest t JOIN t.patient p WHERE t.hwId= :id  ")
	public List<joinclass> getInfo(@Param("id") int id);
	
	@Query(" SELECT new com.epidemic.joinclass(t.patientId, t.id, p.firstName ,p.lastName ,t.hwId,t.diseaseType, t.testType) FROM TestRequest t JOIN t.patient p")
	public List<joinclass> getInfo();
	
	void deleteByHwId(int hw_id);
	
	void delete(TestRequest testrequest);
	
	@Query(value="select count(*) from testrequest tq where tq.hw_id= :hwid",nativeQuery=true)
	int pendingByHw(@Param("hwid") int hwid);

	@Query(value="select * from testrequest tq ",nativeQuery=true)
	List<TestRequest> displayAllRequest();

	@Query(" SELECT new com.epidemic.joinclass(t.patientId, t.id,t.hwId,t.diseaseType, t.testType) FROM TestRequest t JOIN t.patient p where p.state=:state ")
	List<joinclass> displayAllRequest(@Param("state") String state);

	@Query(value="select count(*) from testrequest tq where tq.hw_id= :hwid and tq.disease_type=:diseaseType",nativeQuery=true)
	int pendingByHw(@Param("hwid") int hwid, @Param("diseaseType") String diseaseType);

	@Query(" SELECT new com.epidemic.joinclass(t.patientId, t.id,t.hwId,t.diseaseType, t.testType) FROM TestRequest t JOIN t.patient p")
	List<joinclass> displayAllRequests();
	
}
