package com.example.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.Role;
import com.example.model.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements IUserService
{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}

	@Override
	public HashSet<Role> findAllRoles()
	{
		return new HashSet<Role>(roleRepository.findAll());
	}

	@Override
	public List<User> findAllUsers()
	{
		return userRepository.findAll();

	}

	@Override
	public void saveUser(User user)
	{
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

}
