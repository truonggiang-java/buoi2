package com.example.employee.repository;

import java.util.List;

import com.example.employee.entity.Department;

public interface DepartmentRepository {
	void insert(Department d);
	void update(Department d);
	Department findById(Integer id);
	List<Department> findAllDepartment(); 
}
