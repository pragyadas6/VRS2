package com.howtodoinjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.howtodoinjava.dao.VehicleDAO;
import com.howtodoinjava.entity.VehicleEntity;

@Service
public class VehicleManagerImpl implements VehicleManager {

	@Autowired
    private VehicleDAO vehicleDAO;
	
	@Override
	@Transactional
	public void addVehicle(VehicleEntity vehicle) {
		vehicleDAO.addVehicle(vehicle);
	}
	
	@Override
	@Transactional
	public List<VehicleEntity> getAllVehicles() {
		return vehicleDAO.getAllVehicles();
	}
	
	@Override
	@Transactional
	public void deleteVehicle(String vehicleNo) {
		vehicleDAO.deleteVehicle(vehicleNo);
	}

	@Override
	@Transactional
	public void editVehicle(String vehicleNo) {
		vehicleDAO.editVehicle(vehicleNo);
		
	}

	@Override
	@Transactional
	public VehicleEntity getVehicleById(String vehicleNo) {
		VehicleEntity v1 = null;
		v1 = vehicleDAO.getVehicleById(vehicleNo);
		return v1;
	}
	

	
}
