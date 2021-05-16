package com.example.employee.dto;

import java.util.List;

import com.example.employee.entity.Role;

public class CreateUserDto extends UsersDto{
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
}
