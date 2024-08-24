package com.gopi.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopi.restapp.model.PortDirector;
import com.gopi.restapp.repository.PortDirectorRepository;

import com.gopi.restapp.service.PortDirectorService;

@Service
public class PortDirectorServiceImpl implements PortDirectorService {

    @Autowired
    private PortDirectorRepository PortDirectorRepository;
 
    @Override
    public PortDirector savePortDirector(PortDirector PortDirector) {
        return PortDirectorRepository.save(PortDirector);
    }
 
    @Override
    public PortDirector getPortDirectorById(int PortDirectorId) {
        return PortDirectorRepository.findById(PortDirectorId);
    }
 
    @Override
    public List<PortDirector> getAllPortDirectors() {
        return PortDirectorRepository.findAll();
    }
 
    @Override
    public void deletePortDirectorById(int PortDirectorId) {
        PortDirectorRepository.delete(PortDirectorId);
    }
 
    @Override
    public PortDirector updatePortDirector(int portDirectorId, PortDirector portDirector) {
        if (PortDirectorRepository.findById(portDirectorId) != null) {
            portDirector.setPortDirectorId(portDirectorId);
            return PortDirectorRepository.update(portDirector);
        }
        return null;
    }



}
