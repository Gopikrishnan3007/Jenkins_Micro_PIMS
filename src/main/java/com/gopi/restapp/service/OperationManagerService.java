package com.gopi.restapp.service;

import java.util.List;

import com.gopi.restapp.model.OperationManager;

public interface OperationManagerService {

	OperationManager saveOperationManager(OperationManager logisticManager);

	OperationManager getOperationManagerById(int operationManagerId);

	List<OperationManager> getAllOperationManagers();

	void deleteOperationManagerById(int operationManagerId);

	OperationManager updateOperationManager(int operationManagerId, OperationManager operationManager);

}
