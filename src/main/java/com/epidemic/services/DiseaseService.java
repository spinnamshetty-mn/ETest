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
}
