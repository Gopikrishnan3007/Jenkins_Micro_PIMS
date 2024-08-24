package com.gopi.restapp.service;

import java.util.List;

import com.gopi.restapp.model.VesselOperator;

public interface VesselOperatorService {

	VesselOperator saveVesselOperator(VesselOperator vesselOperator);

	VesselOperator getVesselOperatorById(int vesselOperatorId);
	
	VesselOperator getVesselOperatorByUserName(String userName);

	List<VesselOperator> getAllVesselOperators();

	void deleteVesselOperatorById(int vesselOperatorId);

	VesselOperator updateVesselOperator(int vesselOperatorId, VesselOperator vesselOperator);

}
