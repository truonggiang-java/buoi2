package com.example.employee.dto;

import java.util.List;

import com.example.employee.entity.Role;

public class UsersDto {
	private String name;
	private String email;
	private boolean isActive;
	private String phone;
	private String address;
	private String dob;
	private List<Role> roles;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public UsersDto(String name, String email, boolean isActive, String phone, String address, String dob,
			List<Role> roles) {
		super();
		this.name = name;
		this.email = email;
		this.isActive = isActive;
		this.phone = phone;
		this.address = address;
		this.dob = dob;
		this.roles = roles;
	}
	public UsersDto() {
		super();
	}
	
	
}
