package com.cybage.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.User;
import com.cybage.repository.UserRepository;

@Service
public class UserServiceImpl 
{
	@Autowired
	private  UserRepository userRepository;
	
	public List<User>findAll()
	{
		return userRepository.findAll();
		
	}

	public  User save(User user)
	{
		return userRepository.save(user);
		
	}
	
	public User update(User user)
	{
		return userRepository.save(user);
	}

	public boolean deleteUser(int id) {
		if(userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public User getUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElse(null);
	}


}
