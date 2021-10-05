package com.epidemic.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.epidemic.UpdatedResult;
import com.epidemic.joinclass;
import com.epidemic.model.TestResult;

public interface TestResultRepo extends CrudRepository<TestResult,Integer> {
	
	//--------------------------------------find result by some condition--------------------------------
	@Query(value="select * from testresult tr where tr.patient_id= :patientId order by tr.report_id desc",nativeQuery=true)
	List<TestResult> findAllByPatient(@Param("patientId") int patientId);
	
	@Query(value="select * from (select * from testresult tr where tr.patient_id= :patientId order by tr.report_id desc) where rownum=1",nativeQuery=true)
	TestResult findByPatient(@Param("patientId") int patientId);
	
	@Query(" SELECT new com.epidemic.UpdatedResult(tr.patientId,tr.reportId,p.firstName,p.lastName,tr.status,tr.date,tr.state,tr.city,tr.pincode,tr.diseaseType,tr.testType) FROM TestResult tr JOIN tr.patient p WHERE tr.hwId= :hwId  ")
	List<UpdatedResult> findByOrderByHwIdDesc(@Param("hwId") int hwId);
	
	@Query(value="select distinct(tr.state) from testresult tr",nativeQuery=true)
	List<String> findByState();
	
	@Query(value="select distinct(tr.city) from testresult tr",nativeQuery=true)
	List<String> findByCity();
	
	@Query(value="select distinct(tr.pincode) from testresult tr",nativeQuery=true)
	List<String> findByPincode();
	
	@Query(value="select tr.result_id from testresult tr where tr.report_id= :reportId",nativeQuery=true)
	TestResult findByReportId(@Param("reportId") long reportId);
	
	@Query(value="select tr.result_date from testresult tr where tr.report_id= :report_id",nativeQuery=true)
	Date findByDate(@Param("report_id") long report_id);
	
	@Query(value="select * from testresult tr order by tr.report_id desc",nativeQuery=true)
	List<TestResult> displayAll();
	
	@Query(value="select * from testresult tr where tr.state=:state order by tr.report_id desc",nativeQuery=true)
	List<TestResult> displayAll(@Param("state") String state);

	//----------------------------------------------count results by some condition------------------------
	
	@Query(value="select count(*) from testresult tr",nativeQuery=true)
	int totalAllTest();

	@Query(value="select count(distinct(patient_id)) from testresult tr where tr.status='positive' ",nativeQuery=true)
	int countDistinctPositive();

	@Query(value="select count(*) from testresult tr where tr.status='positive' ",nativeQuery=true)
	int countAllPositive();
	
	@Query(value="select count(*) from testresult tr where tr.city= :name",nativeQuery=true)
	int totalTestCity(@Param("name") String name);
	
	@Query(value="select count(*) from testresult tr where tr.state= :name",nativeQuery=true)
	int totalTestState(@Param("name") String name);
	
	@Query(value="select count(*) from testresult tr where tr.pincode= :name",nativeQuery=true)
	int totalTestPincode(@Param("name") int name);
	
	@Query(value="select count(distinct(patient_id)) from testresult tr where tr.status='positive' and tr.state= :name ",nativeQuery=true)
	int totalCasesState(@Param("name") String name);
	
	@Query(value="select count(distinct(patient_id)) from testresult tr where tr.status='positive' and tr.city= :name ",nativeQuery=true)
	int totalCasesCity(@Param("name") String name);
	
	@Query(value="select count(distinct(patient_id)) from testresult tr where tr.status='positive' and tr.pincode= :name ",nativeQuery=true)
	int totalCasesPincode(@Param("name") int name);
	
	@Query(value="select count(*) from testresult tr where tr.hw_id= :hwid",nativeQuery=true)
	int totalTestByHwId(@Param("hwid") int hwid);

	@Query(value="select count(*) from testresult tr where tr.hw_id= :hwid and tr.disease_type=:diseaseType",nativeQuery=true)
	int totalTestByHwId(@Param("hwid") int hwid, @Param("diseaseType")String diseaseType);
	
	
	@Query(value="select count(*) from testresult tr where tr.city= :name and tr.disease_type=:diseaseType",nativeQuery=true)
	int totalTestCity(@Param("name") String name,@Param("diseaseType") String diseaseType);
	
	@Query(value="select count(*) from testresult tr where tr.state= :name and tr.disease_type=:diseaseType",nativeQuery=true)
	int totalTestState(@Param("name") String name,@Param("diseaseType") String diseaseType);
	
	@Query(value="select count(*) from testresult tr where tr.pincode= :name and tr.disease_type=:diseaseType",nativeQuery=true)
	int totalTestPincode(@Param("name") int name,@Param("diseaseType") String diseaseType);

	
	@Query(value="select count(distinct(patient_id)) from testresult tr where tr.status='positive' and tr.state= :name and tr.disease_type=:diseaseType ",nativeQuery=true)
	int totalCasesState(@Param("name") String name,@Param("diseaseType") String diseaseType);
	
	@Query(value="select count(distinct(patient_id)) from testresult tr where tr.status='positive' and tr.city= :name and tr.disease_type=:diseaseType ",nativeQuery=true)
	int totalCasesCity(@Param("name") String name,@Param("diseaseType") String diseaseType);
	
	@Query(value="select count(distinct(patient_id)) from testresult tr where tr.status='positive' and tr.pincode= :name and tr.disease_type=:diseaseType",nativeQuery=true)
	int totalCasesPincode(@Param("name") int name,@Param("diseaseType") String diseaseType);

	@Query(value="select count(*) from testresult tr where tr.status='positive' and tr.disease_type=:diseaseType",nativeQuery=true)
	int countAllPositive(@Param("diseaseType") String diseaseType);
	
	@Query(value="select count(*) from testresult tr where tr.disease_type=:diseaseType",nativeQuery=true)
	int countAllTest(@Param("diseaseType") String diseaseType);
	
	
	
	
	
}
