package com.gopi.restapp.repositoryimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopi.restapp.model.Invoice;
import com.gopi.restapp.repository.InvoiceRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class InvoiceRepositoryImpl implements InvoiceRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Invoice findById(Long id) {
		return entityManager.find(Invoice.class, id);
	}

	public List<Invoice> findAll() {
		return entityManager.createQuery("SELECT i FROM Invoice i", Invoice.class).getResultList();
	}

	public Invoice save(Invoice Invoice) {
		entityManager.persist(Invoice);
		return Invoice;
	}

	public Invoice update(Invoice Invoice) {
		return entityManager.merge(Invoice);
	}

	public void delete(Long id) {
		Invoice Invoice = findById(id);
		if (Invoice != null) {
			entityManager.remove(Invoice);
		}
	}

}
