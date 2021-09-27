package com.epidemic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.epidemic.model.Patient;

public interface PatientRepo extends CrudRepository<Patient,Long> {
	Patient findByEmail(String email);
	Patient findById(int id);
}
