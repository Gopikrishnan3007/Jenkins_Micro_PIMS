package com.gopi.restapp.repositoryimpl;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopi.restapp.model.OperationManager;
import com.gopi.restapp.repository.OperationManagerRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class OperationManagerRepositoryImpl implements OperationManagerRepository {

    
    @PersistenceContext
    private EntityManager entityManager;
 
    public OperationManager findById(int id) {
        return entityManager.find(OperationManager.class, id);
    }
 
    public List<OperationManager> findAll() {
        return entityManager.createQuery("SELECT o FROM OperationManager o", OperationManager.class).getResultList();
    }
 
    public OperationManager save(OperationManager operationManager) {
        entityManager.persist(operationManager);
        return operationManager;
    }
 
    public OperationManager update(OperationManager operationManager) {
        return entityManager.merge(operationManager);
    }
 
    public void delete(int id) {
        OperationManager operationManager = findById(id);
        if (operationManager != null) {
            entityManager.remove(operationManager);
        }
    }
 
	
}
