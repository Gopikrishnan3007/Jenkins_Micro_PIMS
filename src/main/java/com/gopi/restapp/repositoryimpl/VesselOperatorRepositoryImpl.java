package com.gopi.restapp.repositoryimpl;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopi.restapp.model.VesselOperator;
import com.gopi.restapp.repository.VesselOperatorRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VesselOperatorRepositoryImpl implements VesselOperatorRepository {

    
    @PersistenceContext
    private EntityManager entityManager;
 
    public VesselOperator findById(int id) {
        return entityManager.find(VesselOperator.class, id);
    }
 
    public List<VesselOperator> findAll() {
        return entityManager.createQuery("SELECT o FROM VesselOperator o", VesselOperator.class).getResultList();
    }
 
    public VesselOperator save(VesselOperator vesselOperator) {
        entityManager.persist(vesselOperator);
        return vesselOperator;
    }
 
    public VesselOperator update(VesselOperator vesselOperator) {
        return entityManager.merge(vesselOperator);
    }
 
    public void delete(int id) {
        VesselOperator vesselOperator = findById(id);
        if (vesselOperator != null) {
            entityManager.remove(vesselOperator);
        }
    }

	@Override
	public VesselOperator findByUserName(String userName) {
		String jpql = "SELECT l FROM VesselOperator l WHERE l.userName = :userName";
		TypedQuery<VesselOperator> query = entityManager.createQuery(jpql, VesselOperator.class);
		query.setParameter("userName", userName);

		try {
			return query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			return null;
		}
	}
 
	
}
