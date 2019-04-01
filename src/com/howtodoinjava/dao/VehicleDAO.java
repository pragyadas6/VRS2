package com.howtodoinjava.dao;

import java.util.List;

import com.howtodoinjava.entity.VehicleEntity;

public interface VehicleDAO {

	public void addVehicle(VehicleEntity vehicle);
	public List<VehicleEntity> getAllVehicles();
	public void deleteVehicle(String vehicleNo);
	public void editVehicle(String vehicleNo);
	public VehicleEntity getVehicleById(String vehicleNo);
	
}
