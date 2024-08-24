package com.gopi.restapp.repository;

import java.util.List;

import com.gopi.restapp.model.OperationManager;

public interface OperationManagerRepository {

	public OperationManager findById(int id);
	
	public List<OperationManager> findAll();
	
	public OperationManager save(OperationManager operationManager);
	
	public OperationManager update(OperationManager operationManager);
	
	public void delete(int id);
}
