package com.example.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employee.entity.Employee;
import com.example.employee.page.EmployeePage;
import com.example.employee.page.EmployeeSearchCriteria;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void insert(Employee e) {
		// TODO Auto-generated method stub
		employeeRepository.insert(e);
	}
	@Override
	public void update(Employee e) {
		employeeRepository.update(e);
		
	}
	@Override
	public Employee findById(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}
	@Override
	public Page<Employee> findAllEmployee(EmployeePage employeePage, EmployeeSearchCriteria employeeSearchCriteria) {
		// TODO Auto-generated method stub
		return employeeRepository.findAllEmployees(employeePage, employeeSearchCriteria);
	}
	
	
}
