package com.example.employee.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.employee.entity.Users;
import com.example.employee.service.UsersService;

@Service
public class JWTUsersDetailService implements UserDetailsService{
	
	
	private UsersService usersService;
	
	public JWTUsersDetailService(UsersService usersService) {
		this.usersService = usersService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Users user=usersService.findByName(username);
			return JWTUsersDetailFactory.create(user);
		} catch (Exception e) {
			throw new UsernameNotFoundException(String.format("No user found with username %s", username) +e);
		}
	}

}
