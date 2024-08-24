package com.gopi.restapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tracks")
public class Track {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trackId;

	private String shipRequest;
	private String berthBooking;
	private String preArrivalConfirmation;
	private String pilotage;
	private String cargo;
	private String documentation;
	private String billing;
	private String portClearance;
	private String pilotageOutbound;
	
	@OneToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;
	


	public Track() {
		super();
	}

	public Track(Long trackId, String shipRequest, String berthBooking, String preArrivalConfirmation, String pilotage,
			String cargo, String documentation, String billing, String portClearance, String pilotageOutbound,
			Ship ship) {
		super();
		this.trackId = trackId;
		this.shipRequest = shipRequest;
		this.berthBooking = berthBooking;
		this.preArrivalConfirmation = preArrivalConfirmation;
		this.pilotage = pilotage;
		this.cargo = cargo;
		this.documentation = documentation;
		this.billing = billing;
		this.portClearance = portClearance;
		this.pilotageOutbound = pilotageOutbound;
		this.ship = ship;

	}

	public Long getTrackId() {
		return trackId;
	}

	public String getShipRequest() {
		return shipRequest;
	}

	public String getBerthBooking() {
		return berthBooking;
	}

	public String getPreArrivalConfirmation() {
		return preArrivalConfirmation;
	}

	public String getPilotage() {
		return pilotage;
	}

	public String getCargo() {
		return cargo;
	}

	public String getDocumentation() {
		return documentation;
	}

	public String getBilling() {
		return billing;
	}

	public String getPortClearance() {
		return portClearance;
	}

	public String getPilotageOutbound() {
		return pilotageOutbound;
	}

	public Ship getShip() {
		return ship;
	}



	public void setTrackId(long trackId2) {
		this.trackId = trackId2;
	}

	public void setShipRequest(String shipRequest) {
		this.shipRequest = shipRequest;
	}

	public void setBerthBooking(String berthBooking) {
		this.berthBooking = berthBooking;
	}

	public void setPreArrivalConfirmation(String preArrivalConfirmation) {
		this.preArrivalConfirmation = preArrivalConfirmation;
	}

	public void setPilotage(String pilotage) {
		this.pilotage = pilotage;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	public void setBilling(String billing) {
		this.billing = billing;
	}

	public void setPortClearance(String portClearance) {
		this.portClearance = portClearance;
	}

	public void setPilotageOutbound(String pilotageOutbound) {
		this.pilotageOutbound = pilotageOutbound;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}



	@Override
	public String toString() {
		return "Track [trackId=" + trackId + ", shipRequest=" + shipRequest + ", berthBooking=" + berthBooking
				+ ", preArrivalConfirmation=" + preArrivalConfirmation + ", pilotage=" + pilotage + ", cargo=" + cargo
				+ ", documentation=" + documentation + ", billing=" + billing + ", portClearance=" + portClearance
				+ ", pilotageOutbound=" + pilotageOutbound + ", ship=" + ship +  "]";
	}
	
	

	
}