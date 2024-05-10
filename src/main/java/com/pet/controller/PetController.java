package com.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pet.bean.Pet;
import com.pet.repository.PetDAO;
import com.pet.repository.PetDAOImpl;

@RestController
@CrossOrigin("*")
public class PetController extends PetDAOImpl {

	@Autowired
	PetDAO petdao;

	// to insert the data
	@PostMapping("/doPetInsert")
	public Pet newpet(@RequestBody Pet newPet) {
		return petdao.newPet(newPet);

	}

	// to get all the data from the database
	@GetMapping("/getAllPetList")
	List<Pet> getAllpets() {
		return petdao.getAllPets();
	}

	// get the data from name
	@GetMapping("/findByPetName/{petName}")
	public List<Pet> getCoursebyName(@PathVariable String petName) {
		return petdao.getCourseByName(petName);

	}

	// get by id
	@GetMapping("/GetPetId/{petId}")
	public Pet doCoursefind(@PathVariable("petId") int petId) {
		return petdao.doCourseFind(petId);
	}

	// to get all the Id
	@GetMapping("/getPetIdList")
	public List<Integer> getpetlist() {
		return petdao.getPetbylist();
	}

}
