package com.example.employee.convertor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.example.employee.entity.Role;

public class RoleConvertor {

	public List<Role> apply(int roleNumber) {
		List<Role> roles = new ArrayList<>();
		Role[] roleNames = Role.values();
		for (Role role : roleNames) {
			if ((roleNumber & role.getRoleNumber()) > 0) {
				roles.add(role);
			}
		}
		return roles;
	}

	public int apply(List<Role> roles) {
		if (roles != null && roles.size() > 0) {
			int roleNumber = 0;
			for (Role r : roles) {
				roleNumber += r.getRoleNumber();
			}
			return roleNumber;
		}
		return 0;
	}

	public int apply(Collection<? extends GrantedAuthority> authorities) {
		List<Role> roles = new ArrayList<>();
		if (authorities != null && authorities.size() > 0) {
			for (GrantedAuthority authority : authorities) {
				roles.add(Role.valueOf(authority.getAuthority()));
			}
		}
		return apply(roles);
	}
}
