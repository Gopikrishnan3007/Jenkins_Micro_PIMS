package com.gopi.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopi.restapp.model.Invoice;
import com.gopi.restapp.repository.InvoiceRepository;
import com.gopi.restapp.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository InvoiceRepository;
 
    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return InvoiceRepository.save(invoice);
    }
 
    @Override
    public Invoice getInvoiceById(Long invoiceId) {
        return InvoiceRepository.findById(invoiceId);
    }
 
    @Override
    public List<Invoice> getAllInvoices() {
        return InvoiceRepository.findAll();
    }
 
    @Override
    public void deleteInvoiceById(Long invoiceId) {
    	InvoiceRepository.delete(invoiceId);
    }
 
    @Override
    public Invoice updateInvoice(Long invoiceId, Invoice invoice) {
        if (InvoiceRepository.findById(invoiceId) != null) {
            invoice.setInvoiceId(invoiceId);
            return InvoiceRepository.update(invoice);
        }
        return null;
    }

}
