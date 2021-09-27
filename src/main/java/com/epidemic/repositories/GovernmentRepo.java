package com.epidemic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.epidemic.model.Government;

public interface GovernmentRepo extends CrudRepository<Government,Integer> {
	Government findByEmail(String email);
	Government findByGovId(int govId);
}
