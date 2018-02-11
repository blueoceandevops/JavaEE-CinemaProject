package service;

import java.util.Collection;

import entities.Benefit;

public interface BenefitServiceInterface {

	void put(Benefit benefit);
	void delete(Benefit benefit);
	
	Collection<Benefit> selectAll();
	Collection<Benefit> selectByName(String name);
	
}
