package com.gopi.restapp.repository;

import java.util.List;

import com.gopi.restapp.model.Ship;

public interface ShipRepository {

	public Ship findById(Long id);
	
	public Ship findByShipName(String id);
	
	public Ship findByImoNumber(int imoNumber);

	public List<Ship> findAll();
	
	public List<Long> findAllIds();
	
	public List<String> findAllNames();
	
	public Ship save(Ship Ship);

	public Ship update(Ship ship);

	public void delete(Long id);
	
	List<Ship> findByVesselOperator_VesselOperatorId (int VesselOperatorId);
	
	
	
}
