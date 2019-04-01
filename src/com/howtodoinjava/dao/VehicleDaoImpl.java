package com.howtodoinjava.dao;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.entity.VehicleEntity;

@Repository
public class VehicleDaoImpl implements VehicleDAO{

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void addVehicle(VehicleEntity vehicle) {
		this.sessionFactory.getCurrentSession().save(vehicle);
	}
	
	@Override
	public List<VehicleEntity> getAllVehicles() {
        return this.sessionFactory.getCurrentSession().createQuery("from VehicleEntity").list();
    }
	
	@Override
	public void deleteVehicle(String vehicleNo) {
		VehicleEntity vehicle = (VehicleEntity) sessionFactory.getCurrentSession().load(
				VehicleEntity.class, vehicleNo);
        if (null != vehicle) {
        	this.sessionFactory.getCurrentSession().delete(vehicle);
        }
	}
	
	@Override
	public void editVehicle(String vehicleNo) {
		VehicleEntity vehicle = (VehicleEntity) sessionFactory.getCurrentSession().load(
				VehicleEntity.class, vehicleNo);
        if (null != vehicle) {
        	this.sessionFactory.getCurrentSession().update(vehicle);
        }
	}

	@Override
	public VehicleEntity getVehicleById(String vehicleNo) {
		VehicleEntity v1 = null;
		Session s = sessionFactory.getCurrentSession();
		Transaction t = s.beginTransaction();
		Query q = s.createQuery("FROM VehicleEntity v WHERE v.vehicleNo=:vehicleNo");
		q.setParameter("vehicleNo", vehicleNo); 
		return v1;
	}
	
	
	
}
