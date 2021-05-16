package com.example.employee.convertor;

import org.springframework.stereotype.Component;

import com.example.employee.dto.DepartmentDto;
import com.example.employee.entity.Department;

@Component
public class DepartmentConvertor {
	public Department convertor(DepartmentDto departmentDto) {
		Department department=new Department();
		department.setName(departmentDto.getName());
		department.setPhone(departmentDto.getPhone());
		department.setCode(departmentDto.getCode());
		department.setAddress(departmentDto.getAddress());
		return department;
	}
	
	public void apply(DepartmentDto departmentDto,Department department) {
		if(departmentDto.getName() != null) {
			department.setName(departmentDto.getName());
		}
		if(departmentDto.getPhone() != null) {
			department.setPhone(departmentDto.getPhone());
		}
		if(departmentDto.getAddress() != null) {
			department.setAddress(departmentDto.getAddress());
		}
		if(departmentDto.getCode() != null) {
			department.setCode(departmentDto.getCode());
		}
		
	}
}
