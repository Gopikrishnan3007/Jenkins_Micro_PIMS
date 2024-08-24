package com.gopi.restapp.repository;

import java.util.List;

import com.gopi.restapp.model.PortDirector;

public interface PortDirectorRepository {

	public PortDirector findById(int id);
	
	public List<PortDirector> findAll();
	
	public PortDirector save(PortDirector portDirector);
	
	public PortDirector update(PortDirector portDirector);
	
	public void delete(int id);
}
