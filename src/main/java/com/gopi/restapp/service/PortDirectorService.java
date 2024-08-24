package com.gopi.restapp.service;

import java.util.List;

import com.gopi.restapp.model.PortDirector;

public interface PortDirectorService {

	PortDirector savePortDirector(PortDirector logisticManager);

	PortDirector getPortDirectorById(int portDirectorId);

	List<PortDirector> getAllPortDirectors();

	void deletePortDirectorById(int portDirectorId);

	PortDirector updatePortDirector(int portDirectorId, PortDirector portDirector);

}
