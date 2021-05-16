package com.example.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employee.entity.Users;
import com.example.employee.repository.UserRepository;
import com.example.employee.service.UsersService;

@Service
@Transactional(rollbackFor = Exception.class)
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public void save(Users u) {
		if(u.getId() != null) {
			userRepository.update(u);
		}
		else {
			userRepository.insert(u);
		}
		
	}
	@Override
	public Users findByName(String name) {
		
		return userRepository.findByUserName(name);
	}
	
}
