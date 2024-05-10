package com.pet.repository;

import java.util.List;

import com.pet.bean.Pet;

public interface PetDAO {

	public Pet newPet(Pet newPet);

	public List<Pet> getAllPets();

	public List<Pet> getCourseByName(String petName);

	public Pet doCourseFind(int petId);

	public List<Integer> getPetbylist();

}
