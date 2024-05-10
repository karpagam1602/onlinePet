package com.pet.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pet.bean.Pet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class PetDAOImpl implements PetDAO {

	@Autowired
	EntityManager entityMan;

	@Override
	public Pet newPet(Pet newPet) {
		entityMan.persist(newPet);
		return newPet;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pet> getAllPets() {
		return entityMan.createQuery("from Pet").getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override

	public List<Pet> getCourseByName(String petName) {

		Query query = entityMan.createQuery("select c from Pet c where LOWER (petName) LIKE CONCAT('%',:petname,'%')");
		query.setParameter("petname", petName);
		List<Pet> ls = query.getResultList();
		return ls;
	}

	@Override
	public Pet doCourseFind(int petId) {
		return entityMan.find(Pet.class, petId);
	}

	@Override
	public List<Integer> getPetbylist() {

		Query query = entityMan.createQuery("SELECT pet_id FROM pets_db.pet_tbl");
		@SuppressWarnings("unchecked")
		List<Integer> list = query.getResultList();
		return list;
	}

}
