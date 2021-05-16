package com.example.employee.service;

import java.util.List;

import com.example.employee.entity.Department;

public interface DepartmentService {
	void insert(Department d);
	void update(Department d);
	Department findById(Integer id);
	List<Department> findAllDepartment();
}
