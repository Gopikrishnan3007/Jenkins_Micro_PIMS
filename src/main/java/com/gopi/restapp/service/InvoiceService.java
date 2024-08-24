package com.gopi.restapp.service;

import java.util.List;

import com.gopi.restapp.model.Invoice;


public interface InvoiceService {

	Invoice saveInvoice(Invoice invoice);

	Invoice getInvoiceById(Long invoiceId);

	List<Invoice> getAllInvoices();

	void deleteInvoiceById(Long invoiceId);

	Invoice updateInvoice(Long invoiceId, Invoice invoice);

}
