package com.gopi.restapp.service;

import java.util.List;

import com.gopi.restapp.model.Ship;


public interface ShipService {

	Ship saveShip(Ship ship);

	Ship getShipById(Long id);
	
	Ship getShipByShipName(String shipName);
	
	Ship getShipByImoNumber(int imoNumber);

	List<Ship> getAllShips();
	
	List<String> getAllShipsNames();
	
	List <Long> getAllShipsIds();

	void deleteShipById(Long shipId);

	Ship updateShip(Long shipId, Ship ship);
	
	List<Ship> getShipsByVesselOperatorId(int vesselOperatorId);


	
}
