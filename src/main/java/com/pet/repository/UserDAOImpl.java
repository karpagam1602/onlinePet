package com.pet.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pet.bean.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	EntityManager entityMan;

	@Override
	public User newUser(User newUser) {
		entityMan.persist(newUser);
		return newUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		return entityMan.createQuery("from User").getResultList();
	}

	@Override
	public User doCourseFind(int userId) {
		return entityMan.find(User.class, userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getUserbylist() {
		Query q = entityMan.createQuery("SELECT c.userId FROM User c");
		List<Integer> list = q.getResultList();
		return list;
	}


}
