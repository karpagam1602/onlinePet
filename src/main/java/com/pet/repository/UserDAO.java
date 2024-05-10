package com.pet.repository;

import java.util.List;

import com.pet.bean.User;

public interface UserDAO {

	public User newUser(User newUser);

	public List<User> getAllUsers();

	public User doCourseFind(int userId);

	public List<Integer> getUserbylist();

}
