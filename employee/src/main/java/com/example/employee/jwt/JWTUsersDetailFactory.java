package com.example.employee.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.employee.convertor.RoleConvertor;
import com.example.employee.entity.Role;
import com.example.employee.entity.Users;

public final class JWTUsersDetailFactory {
	
	private JWTUsersDetailFactory() {
	}
	
	public static JWTUserDetails create(Users users) {
		return new JWTUserDetails(users.getId(), users.getName(), users.getPassword(), users.getEmail(),
				maptoGrantedAuthority(users.getRoles()), users.isActive());
	}

	public static List<GrantedAuthority> maptoGrantedAuthority(int roleNumber) {
		List<GrantedAuthority> authority = new ArrayList<>();
		RoleConvertor convertor = new RoleConvertor();
		List<Role> roles = convertor.apply(roleNumber);
		for (Role role : roles) {
			authority.add(new SimpleGrantedAuthority(role.toString()));
		}
		return authority;
	}
}
