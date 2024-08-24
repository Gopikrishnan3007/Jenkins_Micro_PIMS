package com.gopi.restapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Resources")
public class Resources {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourcesId;

    private String pilotTeamNumber;
    private String tugNumber;
    private String craneNumber;
    private String employeeTeamNumber;
    
    @OneToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;

	public Resources() {
		super();
	}

	public Resources(Long resourcesId, String pilotTeamNumber, String tugNumber, String craneNumber,
			String employeeTeamNumber, Ship ship) {
		super();
		this.resourcesId = resourcesId;
		this.pilotTeamNumber = pilotTeamNumber;
		this.tugNumber = tugNumber;
		this.craneNumber = craneNumber;
		this.employeeTeamNumber = employeeTeamNumber;
		this.ship = ship;
	}

	public Long getResourcesId() {
		return resourcesId;
	}

	public String getPilotTeamNumber() {
		return pilotTeamNumber;
	}

	public String gettugNumber() {
		return tugNumber;
	}

	public String getCraneNumber() {
		return craneNumber;
	}

	public String getEmployeeTeamNumber() {
		return employeeTeamNumber;
	}

	public Ship getShip() {
		return ship;
	}

	public void setResourcesId(long resourcesId) {
		this.resourcesId = resourcesId;
	}

	public void setPilotTeamNumber(String pilotTeamNumber) {
		this.pilotTeamNumber = pilotTeamNumber;
	}

	public void settugNumber(String tugNumber) {
		this.tugNumber = tugNumber;
	}

	public void setCraneNumber(String craneNumber) {
		this.craneNumber = craneNumber;
	}

	public void setEmployeeTeamNumber(String employeeTeamNumber) {
		this.employeeTeamNumber = employeeTeamNumber;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	@Override
	public String toString() {
		return "Resources [resourcesId=" + resourcesId + ", pilotTeamNumber=" + pilotTeamNumber + ", tugNumber="
				+ tugNumber + ", craneNumber=" + craneNumber + ", employeeTeamNumber=" + employeeTeamNumber + ", ship="
				+ ship + "]";
	}

	
    
	
}