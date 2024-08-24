package com.gopi.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopi.restapp.model.Ship;
import com.gopi.restapp.repository.ShipRepository;
import com.gopi.restapp.service.ShipService;

@Service
public class ShipServiceImpl implements ShipService {

    @Autowired
    private ShipRepository ShipRepository;
 
    @Override
    public Ship saveShip(Ship ship) {
        return ShipRepository.save(ship);
    }
 
    @Override
    public Ship getShipById(Long shipId) {
        return ShipRepository.findById(shipId);
    }
    
    @Override
    public Ship getShipByShipName(String shipName) {
        return ShipRepository.findByShipName(shipName);
    }
    
    @Override
    public Ship getShipByImoNumber(int imoNumber) {
        return ShipRepository.findByImoNumber(imoNumber);
    }
 
    @Override
    public List<Ship> getAllShips() {
        return ShipRepository.findAll();
    }
 
    @Override
    public void deleteShipById(Long shipId) {
    	ShipRepository.delete(shipId);
    }
 
    @Override
    public Ship updateShip(Long shipId, Ship ship) {
        if (ShipRepository.findById(shipId) != null) {
            ship.setShipId(shipId);
            return ShipRepository.update(ship);
        }
        return null;
    }

	@Override
	public List<Long> getAllShipsIds() {
		return ShipRepository.findAllIds();
	}

	@Override
	public List<Ship> getShipsByVesselOperatorId(int vesselOperatorId) {
        return ShipRepository.findByVesselOperator_VesselOperatorId(vesselOperatorId);
    }

	@Override
	public List<String> getAllShipsNames() {
		return ShipRepository.findAllNames();
	}
}
