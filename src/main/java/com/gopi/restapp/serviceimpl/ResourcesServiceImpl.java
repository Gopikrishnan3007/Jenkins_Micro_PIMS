package com.gopi.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopi.restapp.model.Resources;
import com.gopi.restapp.repository.ResourcesRepository;
import com.gopi.restapp.service.ResourcesService;

@Service
public class ResourcesServiceImpl implements ResourcesService {

    @Autowired
    private ResourcesRepository ResourcesRepository;
 
    @Override
    public Resources saveResources(Resources resources) {
        return ResourcesRepository.save(resources);
    }
 
    @Override
    public Resources getResourcesById(int resourcesId) {
        return ResourcesRepository.findById(resourcesId);
    }
 
    @Override
    public List<Resources> getAllResourcess() {
        return ResourcesRepository.findAll();
    }
    
	@Override
	public List<Long> getAllResourcesIds() {
		return ResourcesRepository.findAllIds();
	}
 
    @Override
    public void deleteResourcesById(int resourcesId) {
    	ResourcesRepository.delete(resourcesId);
    }
 
    @Override
    public Resources updateResources(int resourcesId, Resources resources) {
        if (ResourcesRepository.findById(resourcesId) != null) {
            resources.setResourcesId(resourcesId);
            return ResourcesRepository.update(resources);
        }
        return null;
    }

}
