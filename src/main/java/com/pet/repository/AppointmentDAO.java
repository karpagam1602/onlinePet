package com.pet.repository;

import java.util.List;


import com.pet.bean.Appointment;


public interface AppointmentDAO {
	
	
	public Appointment newApp( Appointment newApp);
	public List<Appointment> getAllApps();
	public Appointment doCourseFind( int appId);
	public List<Integer> getAppbylist();
	

	

}
