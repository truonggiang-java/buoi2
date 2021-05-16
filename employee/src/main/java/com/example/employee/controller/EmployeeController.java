package com.example.employee.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.convertor.EmployeeConvertor;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Employee;
import com.example.employee.page.EmployeePage;
import com.example.employee.page.EmployeeSearchCriteria;
import com.example.employee.service.EmployeeService;
import com.sun.mail.iap.Response;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeSevice;
	
	@Autowired
	private EmployeeConvertor employeeConvertor;
	
	@PutMapping("/employee/{id}")
	private Employee update(@RequestBody EmployeeDto employeeDto,@PathVariable("id") Integer id) {
		Employee employee=employeeSevice.findById(id);
		employeeConvertor.apply(employeeDto, employee);
		employeeSevice.update(employee);
		return employee;
	}
	
	@PostMapping("/employee")
	private ResponseEntity<Object> insert(@Valid @RequestBody EmployeeDto employeeDto,Errors errors){
		if(errors.hasErrors()) {
			return new ResponseEntity<>(errors.getAllErrors().stream().map(objectErrors -> objectErrors.getDefaultMessage()).collect(Collectors.toList()),HttpStatus.BAD_REQUEST);
		}
		Employee employee=employeeConvertor.convertor(employeeDto);
		employeeSevice.insert(employee);
		return new ResponseEntity<>("Thêm mới sản phẩm thành công",HttpStatus.OK);
	}
	
	@GetMapping("/employee")
	private ResponseEntity<Page<Employee>> findAllEmployee(EmployeePage employeePage,EmployeeSearchCriteria employeeSearchCriteria){
		return new ResponseEntity<>(employeeSevice.findAllEmployee(employeePage,employeeSearchCriteria),HttpStatus.OK);
	}
	
	@GetMapping("/employee/{id}")
	private ResponseEntity<Object> findById(@PathVariable("id") Integer id){
		return new ResponseEntity<>(employeeSevice.findById(id),HttpStatus.OK);
	}
	
}
