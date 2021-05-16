package com.example.employee.entity;

public enum Role {
	ROLE_ADMIN(1),ROLE_USER(2);
	
	private final int roleNumber;

	public int getRoleNumber() {
		return roleNumber;
	}

	private Role(int roleNumber) {
		this.roleNumber = roleNumber;
	}
	
	
}
