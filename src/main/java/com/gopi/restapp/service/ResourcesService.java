package com.gopi.restapp.service;

import java.util.List;

import com.gopi.restapp.model.Resources;


public interface ResourcesService {

	Resources saveResources(Resources resources);

	Resources getResourcesById(int resourcesId);

	List<Resources> getAllResourcess();
	
	List <Long> getAllResourcesIds();

	void deleteResourcesById(int resourcesId);

	Resources updateResources(int resourcesId, Resources resources);

}
