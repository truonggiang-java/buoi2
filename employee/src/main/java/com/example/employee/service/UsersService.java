package com.example.employee.service;

import com.example.employee.entity.Users;

public interface UsersService {
	void save(Users u);
	Users findByName(String name);
}
