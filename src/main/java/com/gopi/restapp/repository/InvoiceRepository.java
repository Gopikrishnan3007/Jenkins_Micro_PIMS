package com.gopi.restapp.repository;

import java.util.List;

import com.gopi.restapp.model.Invoice;

public interface InvoiceRepository {

	public Invoice findById(Long id);

	public List<Invoice> findAll();

	public Invoice save(Invoice invoice);

	public Invoice update(Invoice invoice);

	public void delete(Long id);
}
