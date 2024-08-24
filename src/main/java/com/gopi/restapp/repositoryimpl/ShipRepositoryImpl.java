package com.gopi.restapp.repositoryimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopi.restapp.model.Ship;
import com.gopi.restapp.repository.ShipRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ShipRepositoryImpl implements ShipRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Ship findById(Long id) {
		return entityManager.find(Ship.class, id);
	}
	
	public Ship findByShipName(String shipName) {
		String jpql = "SELECT s FROM Ship s WHERE s.shipName = :shipName";
		TypedQuery<Ship> query = entityManager.createQuery(jpql, Ship.class);
		query.setParameter("imoNumber", shipName);

		try {
			return query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			return null;
		}
	}

	public Ship findByImoNumber(int imoNumber) {
		String jpql = "SELECT s FROM Ship s WHERE s.imoNumber = :imoNumber";
		TypedQuery<Ship> query = entityManager.createQuery(jpql, Ship.class);
		query.setParameter("imoNumber", imoNumber);

		try {
			return query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			return null;
		}
	}

	public List<Ship> findAll() {
		return entityManager.createQuery("SELECT s FROM Ship s", Ship.class).getResultList();
	}

	@Override
	public List<Long> findAllIds() {
		return entityManager.createQuery("SELECT s.shipId FROM Ship s", Long.class).getResultList();
	}

	public Ship save(Ship ship) {
		entityManager.persist(ship);
		return ship;
	}

	public Ship update(Ship ship) {
		return entityManager.merge(ship);
	}

	public void delete(Long id) {
		Ship ship = findById(id);
		if (ship != null) {
			entityManager.remove(ship);
		}
	}

	@Override
	public List<Ship> findByVesselOperator_VesselOperatorId(int vesselOperatorId) {
		 String sql = "SELECT s FROM Ship s WHERE s.vesselOperator.vesselOperatorId = :vesselOperatorId";
	        TypedQuery<Ship> query = entityManager.createQuery(sql, Ship.class);
	        query.setParameter("vesselOperatorId", vesselOperatorId);

	        try {
	            return query.getResultList();
	        } catch (NoResultException | NonUniqueResultException e) {
	            return null;
	        }
	}

	@Override
	public List<String> findAllNames() {
		return entityManager.createQuery("SELECT s.shipName FROM Ship s", String.class).getResultList();
	}



}
