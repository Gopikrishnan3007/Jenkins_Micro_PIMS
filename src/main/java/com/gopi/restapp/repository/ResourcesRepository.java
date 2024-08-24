package com.gopi.restapp.repository;

import java.util.List;

import com.gopi.restapp.model.Resources;

public interface ResourcesRepository {

	public Resources findById(int id);

	public List<Resources> findAll();

	public Resources save(Resources resources);

	public Resources update(Resources resources);

	public void delete(int id);
	
	public List<Long> findAllIds();
}
