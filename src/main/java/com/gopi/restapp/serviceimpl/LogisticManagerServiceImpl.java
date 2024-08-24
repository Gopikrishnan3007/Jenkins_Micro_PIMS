package com.gopi.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopi.restapp.model.LogisticManager;
import com.gopi.restapp.repository.LogisticManagerRepository;
import com.gopi.restapp.service.LogisticManagerService;

@Service
public class LogisticManagerServiceImpl implements LogisticManagerService {

    @Autowired
    private LogisticManagerRepository logisticManagerRepository;
 
    @Override
    public LogisticManager saveLogisticManager(LogisticManager logisticManager) {
        return logisticManagerRepository.save(logisticManager);
    }
 
    @Override
    public LogisticManager getLogisticManagerById(int logisticManagerId) {
        return logisticManagerRepository.findById(logisticManagerId);
    }
 
    @Override
    public List<LogisticManager> getAllLogisticManagers() {
        return logisticManagerRepository.findAll();
    }
 
    @Override
    public void deleteLogisticManagerById(int logisticManagerId) {
    	logisticManagerRepository.delete(logisticManagerId);
    }
 
    @Override
    public LogisticManager updateLogisticManager(int logisticManagerId, LogisticManager logisticManager) {
        if (logisticManagerRepository.findById(logisticManagerId) != null) {
            logisticManager.setLogisticManagerId(logisticManagerId);
            return logisticManagerRepository.update(logisticManager);
        }
        return null;
    }

	@Override
	public LogisticManager getLogisticManagerByUserName(String userName) {
		return logisticManagerRepository.findByUserName(userName);
	}

}
