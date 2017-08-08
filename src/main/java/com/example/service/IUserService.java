package com.example.service;

import java.util.HashSet;
import java.util.List;

import com.example.model.Role;
import com.example.model.User;

public interface IUserService
{
	public User findUserByEmail(String email);

	public void saveUser(User user);

	List<User> findAllUsers();

	HashSet<Role> findAllRoles();
}
