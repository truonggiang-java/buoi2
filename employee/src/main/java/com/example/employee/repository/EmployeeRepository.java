package com.example.employee.repository;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.employee.entity.Employee;
import com.example.employee.page.EmployeePage;
import com.example.employee.page.EmployeeSearchCriteria;

public interface EmployeeRepository {
	void insert(Employee e);
	void update(Employee e);
	Employee findById(Integer id);
	Page<Employee> findAllEmployees(EmployeePage employeePage,EmployeeSearchCriteria employeeSearchCriteria);
}
