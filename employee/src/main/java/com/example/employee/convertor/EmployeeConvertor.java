package com.example.employee.convertor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Department;
import com.example.employee.entity.Employee;
import com.example.employee.entity.Groups;
import com.example.employee.entity.Position;

@Component
public class EmployeeConvertor {
	public Employee convertor(EmployeeDto employeeDto) {
		
		Employee employee=new Employee();
		Department department=new Department();
		Position position=new Position();
		Groups groups=new Groups();
		
		employee.setEmail(employeeDto.getEmail());
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setJobTitle(employeeDto.getJobTitle());
		employee.setPhone(employeeDto.getPhone());
		employee.setSex(employeeDto.getSex());
		employee.setAddress(employeeDto.getAddress());
		position.setId(employeeDto.getPosition());
		department.setId(employeeDto.getDepartment());
		groups.setId(employeeDto.getGroups());
		employee.setDepartment(department);
		employee.setPosition(position);
		employee.setGroups(groups);
		return employee;
	}
	
	public void apply(EmployeeDto employeeDto,Employee employee) {
		Department department=new Department();
		Position position=new Position();
		Groups groups=new Groups();
		
		if(employeeDto.getLastName() != null) {
			employee.setLastName(employeeDto.getLastName());
		}
		if(employeeDto.getFirstName() != null) {
			employee.setFirstName(employeeDto.getFirstName());
		}
		if(employeeDto.getAddress() !=null) {
			employee.setAddress(employeeDto.getAddress());
		}
		if(employeeDto.getSex() != null) {
			employee.setSex(employeeDto.getSex());
		}
		if(employeeDto.getEmail() != null) {
			employee.setEmail(employeeDto.getEmail());
		}
		if(employeeDto.getJobTitle() !=null) {
			employee.setJobTitle(employeeDto.getJobTitle());
		}
		if(employeeDto.getPhone() !=null) {
			employee.setPhone(employeeDto.getPhone());
		}
		if(employeeDto.getDepartment() !=null) {
			department.setId(employeeDto.getDepartment());
			employee.setDepartment(department);
		}
		if(employeeDto.getPosition() !=null) {
			position.setId(employeeDto.getPosition());
			employee.setPosition(position);
		}
		if(employeeDto.getGroups() !=null) {
			groups.setId(employeeDto.getGroups());
			employee.setGroups(groups);
		}
	}
}
