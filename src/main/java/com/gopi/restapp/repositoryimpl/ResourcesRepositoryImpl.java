package com.gopi.restapp.repositoryimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopi.restapp.model.Resources;
import com.gopi.restapp.repository.ResourcesRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ResourcesRepositoryImpl implements ResourcesRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Resources findById(int id) {
		return entityManager.find(Resources.class, id);
	}

	public List<Resources> findAll() {
		return entityManager.createQuery("SELECT r FROM Resources r", Resources.class).getResultList();
	}
	
	@Override
	public List<Long> findAllIds() {
		return entityManager.createQuery("SELECT r.resourcesId FROM Resources r", Long.class).getResultList();
	}

	public Resources save(Resources resources) {
		entityManager.persist(resources);
		return resources;
	}

	public Resources update(Resources resources) {
		return entityManager.merge(resources);
	}

	public void delete(int id) {
		Resources resources = findById(id);
		if (resources != null) {
			entityManager.remove(resources);
		}
	}

}
