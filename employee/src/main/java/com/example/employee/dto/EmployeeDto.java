package com.example.employee.dto;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.example.employee.entity.Groups;

public class EmployeeDto {
	
	@NotBlank(message = "Phải điền họ. Không được để trống")
	private String lastName;
	
	@NotBlank(message = "Phải điền đầy đủ tên")
	private String firstName;
	
	@Email(message = "Không đúng định dạng email")
	private String email;
	
	@NotBlank(message="Phải nhập địa chỉ")
	private String address;
	
	@NotBlank(message = "Phải nhập số điện thoại")
	private String phone;
	
	@NotBlank(message="Phải nhập giới tính")
	private String sex;
	
	private String jobTitle;
	
	private Integer department;
	
	private Integer position;
	
	private Integer groups;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getGroups() {
		return groups;
	}

	public void setGroups(Integer groups) {
		this.groups = groups;
	}

	public EmployeeDto() {
		super();
	}

	public EmployeeDto(@NotBlank(message = "Phải điền họ. Không được để trống") String lastName,
			@NotBlank(message = "Phải điền đầy đủ tên") String firstName,
			@Email(message = "Không đúng định dạng email") String email,
			@NotBlank(message = "Phải nhập địa chỉ") String address,
			@NotBlank(message = "Phải nhập số điện thoại") String phone,
			@NotBlank(message = "Phải nhập giới tính") String sex, String jobTitle, Integer department,
			Integer position, Integer groups) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.sex = sex;
		this.jobTitle = jobTitle;
		this.department = department;
		this.position = position;
		this.groups = groups;
	}

	


	
	
	

	
	
}
