package com.gopi.restapp.repository;

import java.util.List;

import com.gopi.restapp.model.VesselOperator;

public interface VesselOperatorRepository {

	public VesselOperator findById(int id);
	
	public List<VesselOperator> findAll();
	
	public VesselOperator save(VesselOperator vesselOperator);
	
	public VesselOperator update(VesselOperator vesselOperator);
	
	public VesselOperator findByUserName(String userName);
	
	public void delete(int id);
}
