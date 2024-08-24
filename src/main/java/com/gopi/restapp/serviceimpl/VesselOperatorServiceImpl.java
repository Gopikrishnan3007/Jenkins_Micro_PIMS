package com.gopi.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopi.restapp.model.VesselOperator;
import com.gopi.restapp.repository.VesselOperatorRepository;

import com.gopi.restapp.service.VesselOperatorService;

@Service
public class VesselOperatorServiceImpl implements VesselOperatorService {

    @Autowired
    private VesselOperatorRepository vesselOperatorRepository;
 
    @Override
    public VesselOperator saveVesselOperator(VesselOperator vesselOperator) {
        return vesselOperatorRepository.save(vesselOperator);
    }
 
    @Override
    public VesselOperator getVesselOperatorById(int vesselOperatorId) {
        return vesselOperatorRepository.findById(vesselOperatorId);
    }
 
    @Override
    public List<VesselOperator> getAllVesselOperators() {
        return vesselOperatorRepository.findAll();
    }
 
    @Override
    public void deleteVesselOperatorById(int vesselOperatorId) {
        vesselOperatorRepository.delete(vesselOperatorId);
    }
 
    @Override
    public VesselOperator updateVesselOperator(int vesselOperatorId, VesselOperator vesselOperator) {
        if (vesselOperatorRepository.findById(vesselOperatorId) != null) {
            vesselOperator.setVesselOperatorId(vesselOperatorId);
            return vesselOperatorRepository.update(vesselOperator);
        }
        return null;
    }

	@Override
	public VesselOperator getVesselOperatorByUserName(String userName) {
		return vesselOperatorRepository.findByUserName(userName);
	}



}
