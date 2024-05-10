package com.pet.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pet.bean.Appointment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class AppointmentDAOImpl implements AppointmentDAO {

	@Autowired
	EntityManager entityMan;

	@Override
	public Appointment newApp(Appointment newApp) {
		entityMan.persist(newApp);
		return newApp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getAllApps() {

		return entityMan.createQuery("from Appointment").getResultList();
	}

	@Override
	public Appointment doCourseFind(int appId) {
		return entityMan.find(Appointment.class, appId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getAppbylist() {

		Query q = entityMan.createQuery("SELECT c.appId FROM Appointment c");
		List<Integer> list = q.getResultList();
		return list;
	}

}
