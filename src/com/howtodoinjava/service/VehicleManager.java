package com.howtodoinjava.service;

import java.util.List;

import com.howtodoinjava.entity.VehicleEntity;

public interface VehicleManager {

	public List<VehicleEntity> getAllVehicles();
	public void addVehicle(VehicleEntity vehicle);
	public void deleteVehicle(String vehicleNo);
	public void editVehicle(String vehicleNo);
	public VehicleEntity getVehicleById(String vehicleNo);
}
