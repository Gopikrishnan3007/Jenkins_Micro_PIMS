package com.gopi.restapp.repositoryimpl;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopi.restapp.model.LogisticManager;
import com.gopi.restapp.repository.LogisticManagerRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LogisticManagerRepositoryImpl implements LogisticManagerRepository {

    
    @PersistenceContext
    private EntityManager entityManager;
 
    public LogisticManager findById(int id) {
        return entityManager.find(LogisticManager.class, id);
    }
 
    public List<LogisticManager> findAll() {
        return entityManager.createQuery("SELECT l FROM LogisticManager l", LogisticManager.class).getResultList();
    }
 
    public LogisticManager save(LogisticManager LogisticManager) {
        entityManager.persist(LogisticManager);
        return LogisticManager;
    }
 
    public LogisticManager update(LogisticManager LogisticManager) {
        return entityManager.merge(LogisticManager);
    }
 
    public void delete(int id) {
        LogisticManager logisticManager = findById(id);
        if (logisticManager != null) {
            entityManager.remove(logisticManager);
        }
    }

	@Override
	public LogisticManager findByUserName(String userName) {
		String jpql = "SELECT l FROM LogisticManager l WHERE l.userName = :userName";
		TypedQuery<LogisticManager> query = entityManager.createQuery(jpql, LogisticManager.class);
		query.setParameter("userName", userName);

		try {
			return query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			return null;
		}
	}
 
	
}
