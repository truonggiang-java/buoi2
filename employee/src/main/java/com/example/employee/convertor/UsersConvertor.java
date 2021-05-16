package com.example.employee.convertor;

import java.text.DateFormat;
import java.text.ParseException;

import com.example.employee.dto.CreateUserDto;
import com.example.employee.entity.Users;

public class UsersConvertor {
	
	private DateFormat dateFormat;
	private RoleConvertor roleConvertor;
	public Users apply(CreateUserDto createUserDto) throws ParseException {
		Users user=new Users();
		user.setName(createUserDto.getName());
		user.setEmail(createUserDto.getEmail());
		user.setAddress(createUserDto.getAddress());
		user.setPassword(createUserDto.getPassword());
		user.setPhone(createUserDto.getPhone());
		user.setActive(true);
		user.setRoles(roleConvertor.apply(createUserDto.getRoles()));
		user.setDob(dateFormat.parse(createUserDto.getDob()));
		return user;
	}
}
