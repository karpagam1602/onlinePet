package com.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pet.bean.Appointment;
import com.pet.repository.AppointmentDAO;
import com.pet.repository.AppointmentDAOImpl;

@RestController
@CrossOrigin("*")
public class AppointmentController extends AppointmentDAOImpl {

	@Autowired
	AppointmentDAO appdao;

	// to insert the data
	@PostMapping("/doAppInsert")
	public Appointment newapp(@RequestBody Appointment newApp) {
		return appdao.newApp(newApp);

	}

	// to get all the data from the database
	@GetMapping("/getAllAppList")
	public List<Appointment> getAllapps() {
		return appdao.getAllApps();
	}

	// get by id
	@GetMapping("/GetAppId/{appId}")
	public Appointment docoursefind(@PathVariable("appId") int appId) {
		return appdao.doCourseFind(appId);
	}

	// to get all the Id
	@GetMapping("/getAppIdList")
	public List<Integer> getappbylist() {
		return appdao.getAppbylist();
	}

}
