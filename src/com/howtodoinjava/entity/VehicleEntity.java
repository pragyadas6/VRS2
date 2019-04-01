package com.howtodoinjava.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="VehicleEntity")
@Table(name="tbl_vehicleentity")
public class VehicleEntity {

	@Id
	@Column(name="VehicleNo")
	private String vehicleNo;
	
	
	private String branch;
	
	
	private String vehicleType;
	
	
	private String insuranceExpiryDate;
	
	
	private String lastServiceDate;
	
	
	private String serviceDueDate;

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getInsuranceExpiryDate() {
		return insuranceExpiryDate;
	}

	public void setInsuranceExpiryDate(String insuranceExpiryDate) {
		this.insuranceExpiryDate = insuranceExpiryDate;
	}

	public String getLastServiceDate() {
		return lastServiceDate;
	}

	public void setLastServiceDate(String lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}

	public String getServiceDueDate() {
		return serviceDueDate;
	}

	public void setServiceDueDate(String serviceDueDate) {
		this.serviceDueDate = serviceDueDate;
	}
	
}