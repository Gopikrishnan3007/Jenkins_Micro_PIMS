package com.gopi.restapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopi.restapp.model.Resources;
import com.gopi.restapp.model.Ship;
import com.gopi.restapp.service.ResourcesService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/logisticnmanager")
public class LogisticManagerController {
	@Autowired
	private ResourcesService resourcesService;
 
    @GetMapping("/resources/all")
    public List<Resources> getAllResourcess() {
        return resourcesService.getAllResourcess();
    }
 
    @GetMapping("/resources/ids")
    public List<Long> getAllResourcesIds() {
        return resourcesService.getAllResourcesIds();
    }
    
    @GetMapping("/resources/{id}")
    public Resources getResourcesById(@PathVariable int id) {
        return resourcesService.getResourcesById(id);
    }
 
    @PostMapping("/resources")
    public Resources createResources(@RequestBody Resources Resources) {
        resourcesService.saveResources(Resources);
        return Resources;
    }
 
    @PutMapping("/resources/{id}")
    public Resources updateResources(@PathVariable int id, @RequestBody Resources Resources) {
        Resources.setResourcesId(id);
        resourcesService.updateResources(id, Resources);
        return Resources;
    }
 
    @DeleteMapping("/resources/{id}")
    public void deleteResources(@PathVariable int id) {
        resourcesService.deleteResourcesById(id);
    }
    
    
}
