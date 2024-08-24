package com.gopi.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopi.restapp.model.OperationManager;
import com.gopi.restapp.repository.OperationManagerRepository;

import com.gopi.restapp.service.OperationManagerService;

@Service
public class OperationManagerServiceImpl implements OperationManagerService {

    @Autowired
    private OperationManagerRepository OperationManagerRepository;
 
    @Override
    public OperationManager saveOperationManager(OperationManager OperationManager) {
        return OperationManagerRepository.save(OperationManager);
    }
 
    @Override
    public OperationManager getOperationManagerById(int OperationManagerId) {
        return OperationManagerRepository.findById(OperationManagerId);
    }
 
    @Override
    public List<OperationManager> getAllOperationManagers() {
        return OperationManagerRepository.findAll();
    }
 
    @Override
    public void deleteOperationManagerById(int OperationManagerId) {
        OperationManagerRepository.delete(OperationManagerId);
    }
 
    @Override
    public OperationManager updateOperationManager(int operationManagerId, OperationManager operationManager) {
        if (OperationManagerRepository.findById(operationManagerId) != null) {
            operationManager.setOperationManagerId(operationManagerId);
            return OperationManagerRepository.update(operationManager);
        }
        return null;
    }



}
