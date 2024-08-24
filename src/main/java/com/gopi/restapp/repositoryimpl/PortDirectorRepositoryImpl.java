package com.gopi.restapp.repositoryimpl;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopi.restapp.model.PortDirector;
import com.gopi.restapp.repository.PortDirectorRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PortDirectorRepositoryImpl implements PortDirectorRepository {

    
    @PersistenceContext
    private EntityManager entityManager;
 
    public PortDirector findById(int id) {
        return entityManager.find(PortDirector.class, id);
    }
 
    public List<PortDirector> findAll() {
        return entityManager.createQuery("SELECT o FROM PortDirector o", PortDirector.class).getResultList();
    }
 
    public PortDirector save(PortDirector portDirector) {
        entityManager.persist(portDirector);
        return portDirector;
    }
 
    public PortDirector update(PortDirector portDirector) {
        return entityManager.merge(portDirector);
    }
 
    public void delete(int id) {
        PortDirector portDirector = findById(id);
        if (portDirector != null) {
            entityManager.remove(portDirector);
        }
    }
 
	
}
