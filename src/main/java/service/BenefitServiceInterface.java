package service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import entities.Benefit;

@Service
public interface BenefitServiceInterface {

	void put(Benefit benefit);
	void delete(Benefit benefit);
	
	Collection<Benefit> selectAll();
	Collection<Benefit> selectByName(String name);
	
}
