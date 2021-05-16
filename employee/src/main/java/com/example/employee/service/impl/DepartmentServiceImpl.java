package com.example.employee.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employee.entity.Department;
import com.example.employee.repository.DepartmentRepository;
import com.example.employee.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	@Transactional
	public void insert(Department d) {
		departmentRepository.insert(d);
		
	}

	@Override
	@Transactional
	public void update(Department d) {
		departmentRepository.update(d);
	}

	@Override
	public Department findById(Integer id) {
		
		return departmentRepository.findById(id);
	}

	@Override
	public List<Department> findAllDepartment() {
		// TODO Auto-generated method stub
		return departmentRepository.findAllDepartment();
	}
	
}
