package com.gopi.restapp.repository;

import java.util.List;

import com.gopi.restapp.model.LogisticManager;

public interface LogisticManagerRepository {

	public LogisticManager findById(int id);
	
	public List<LogisticManager> findAll();
	
	public LogisticManager save(LogisticManager LogisticManager);
	
	public LogisticManager update(LogisticManager LogisticManager);
	
	public LogisticManager findByUserName(String userName);
	
	public void delete(int id);
}
