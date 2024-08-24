package com.gopi.restapp.service;

import java.util.List;

import com.gopi.restapp.model.LogisticManager;

public interface LogisticManagerService {

	LogisticManager saveLogisticManager(LogisticManager logisticManager);

	LogisticManager getLogisticManagerById(int logisticManagerId);

	List<LogisticManager> getAllLogisticManagers();
	
	LogisticManager getLogisticManagerByUserName(String userName);

	void deleteLogisticManagerById(int logisticManagerId);

	LogisticManager updateLogisticManager(int logisticManagerId, LogisticManager logisticManager);

}
