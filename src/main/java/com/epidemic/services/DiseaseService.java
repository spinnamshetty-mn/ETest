package com.epidemic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epidemic.model.Disease;
import com.epidemic.repositories.DiseaseRepo;

@Service
@Transactional
public class DiseaseService {
	
	@Autowired 
	private DiseaseRepo diseaseRepo;
	
	public String getAllDisease(){
		return diseaseRepo.findAllDisease();
	}
	public void addDisease(Disease disease) {
		diseaseRepo.save(disease);
	}
	public Disease findDisease(String diseaseType) {
		return diseaseRepo.findDisease(diseaseType);
	}
	public List<String> getDiseaseList(){
		return diseaseRepo.findAllDiseases();
	}
	public Disease findDiseaseEntity(String disease,String test) {
		return diseaseRepo.isPresent(disease,test);
	}
	public boolean isPresent(String disease,String test) {
		if( diseaseRepo.isPresent(disease,test)!=null) {
			return true;
		}
		return false;
	}
	
	public List<String> getTestList(String diseaseType) {
		// TODO Auto-generated method stub
		return diseaseRepo.getTestList( diseaseType);
	}
}
