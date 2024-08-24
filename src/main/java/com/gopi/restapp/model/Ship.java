package com.gopi.restapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ships")
public class Ship {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shipId;

	private String shipName;
	private Long imoNumber;
	private String mmsiNumber;
	private String typeOfShip;
	private String previousPort;
	private String arrivalDateTime;
	private String request;
	private String berth;
    private String serviceType;
	
	@ManyToOne
    @JoinColumn(name = "vesselOperator_id")
	private VesselOperator vesselOperator;
	
	@OneToOne
	@JoinColumn(name = "invoice_id")
	private Invoice invoice;

	public Ship() {
		super();
	}

	public Ship(Long shipId, String shipName, Long imoNumber, String mmsiNumber, String typeOfShip, String previousPort,
			String arrivalDateTime, String request, String berth, String serviceType, VesselOperator vesselOperator,
			Invoice invoice) {
		super();
		this.shipId = shipId;
		this.shipName = shipName;
		this.imoNumber = imoNumber;
		this.mmsiNumber = mmsiNumber;
		this.typeOfShip = typeOfShip;
		this.previousPort = previousPort;
		this.arrivalDateTime = arrivalDateTime;
		this.request = request;
		this.berth = berth;
		this.serviceType = serviceType;
		this.vesselOperator = vesselOperator;
		this.invoice = invoice;
	}

	public Long getShipId() {
		return shipId;
	}

	public String getShipName() {
		return shipName;
	}

	public Long getImoNumber() {
		return imoNumber;
	}

	public String getMmsiNumber() {
		return mmsiNumber;
	}

	public String getTypeOfShip() {
		return typeOfShip;
	}

	public String getPreviousPort() {
		return previousPort;
	}

	public String getArrivalDateTime() {
		return arrivalDateTime;
	}

	public String getRequest() {
		return request;
	}

	public String getBerth() {
		return berth;
	}

	public String getServiceType() {
		return serviceType;
	}

	public VesselOperator getVesselOperator() {
		return vesselOperator;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setShipId(Long shipId) {
		this.shipId = shipId;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public void setImoNumber(Long imoNumber) {
		this.imoNumber = imoNumber;
	}

	public void setMmsiNumber(String mmsiNumber) {
		this.mmsiNumber = mmsiNumber;
	}

	public void setTypeOfShip(String typeOfShip) {
		this.typeOfShip = typeOfShip;
	}

	public void setPreviousPort(String previousPort) {
		this.previousPort = previousPort;
	}

	public void setArrivalDateTime(String arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public void setBerth(String berth) {
		this.berth = berth;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public void setVesselOperator(VesselOperator vesselOperator) {
		this.vesselOperator = vesselOperator;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		return "Ship [shipId=" + shipId + ", shipName=" + shipName + ", imoNumber=" + imoNumber + ", mmsiNumber="
				+ mmsiNumber + ", typeOfShip=" + typeOfShip + ", previousPort=" + previousPort + ", arrivalDateTime="
				+ arrivalDateTime + ", request=" + request + ", berth=" + berth + ", serviceType=" + serviceType
				+ ", vesselOperator=" + vesselOperator + ", invoice=" + invoice + "]";
	}
	
	

	
}