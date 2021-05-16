package com.example.employee.repository;

import com.example.employee.entity.Users;

public interface UserRepository {
	Users findByUserName(String name);
	void insert(Users u);
	void update(Users u);
}
