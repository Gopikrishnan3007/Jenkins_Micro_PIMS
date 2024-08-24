package com.gopi.restapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;
    private String invoiceNumber;
    private String invoiceDate;
    private String dueDate;
    private String portName;
    private String serviceDuration;
    private String unitCost;
    private String totalCost;
    private String additionalCharges;
    private String taxes;

    public Invoice() {
        super();
    }

	public Invoice(Long invoiceId, String invoiceNumber, String invoiceDate, String dueDate, String portName,
			String serviceDuration, String unitCost, String totalCost, String additionalCharges,
			String taxes) {
		super();
		this.invoiceId = invoiceId;
		this.invoiceNumber = invoiceNumber;
		this.invoiceDate = invoiceDate;
		this.dueDate = dueDate;
		this.portName = portName;
		this.serviceDuration = serviceDuration;
		this.unitCost = unitCost;
		this.totalCost = totalCost;
		this.additionalCharges = additionalCharges;
		this.taxes = taxes;
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public String getPortName() {
		return portName;
	}



	public String getServiceDuration() {
		return serviceDuration;
	}

	public String getUnitCost() {
		return unitCost;
	}

	public String getTotalCost() {
		return totalCost;
	}

	public String getAdditionalCharges() {
		return additionalCharges;
	}

	public String getTaxes() {
		return taxes;
	}

	public void setInvoiceId(Long id) {
		this.invoiceId = id;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}



	public void setServiceDuration(String serviceDuration) {
		this.serviceDuration = serviceDuration;
	}

	public void setUnitCost(String unitCost) {
		this.unitCost = unitCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

	public void setAdditionalCharges(String additionalCharges) {
		this.additionalCharges = additionalCharges;
	}

	public void setTaxes(String taxes) {
		this.taxes = taxes;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", invoiceNumber=" + invoiceNumber + ", invoiceDate=" + invoiceDate
				+ ", dueDate=" + dueDate + ", portName=" + portName + ", serviceDuration=" + serviceDuration
				+ ", unitCost=" + unitCost + ", totalCost=" + totalCost + ", additionalCharges=" + additionalCharges
				+ ", taxes=" + taxes + "]";
	}



   
}
