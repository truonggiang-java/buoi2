package com.example.employee.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.convertor.DepartmentConvertor;
import com.example.employee.dto.DepartmentDto;
import com.example.employee.entity.Department;
import com.example.employee.service.DepartmentService;

@RestController
@RequestMapping(value= "/api/v1")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private DepartmentConvertor departmentConvertor;

	@PostMapping("/department")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Object> insert(@Valid @RequestBody DepartmentDto departmentDto, Errors errors) {
		if (errors.hasErrors()) {

			return new ResponseEntity<>(errors.getAllErrors().stream()
					.map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList()),
					HttpStatus.BAD_REQUEST);
			}
		Department department = departmentConvertor.convertor(departmentDto);
		departmentService.insert(department);
		return new ResponseEntity<>("Thêm mới phòng ban thành công", HttpStatus.OK);

	}
	
	@PutMapping("/department/{id}")
	public Department update(@RequestBody DepartmentDto departmentDto,@PathVariable("id") Integer id) {
		Department department=departmentService.findById(id);
		departmentConvertor.apply(departmentDto, department);
		departmentService.update(department);
		return department;
	}
	
	@GetMapping("/department/{id}")
	public ResponseEntity<Object> findById(@PathVariable("id") Integer id){
		return new ResponseEntity<>(departmentService.findById(id),HttpStatus.OK);
	}
	
	@GetMapping("/department")
	public ResponseEntity<Object> findAllById(){
		return new ResponseEntity<>(departmentService.findAllDepartment(),HttpStatus.OK);
	}
}
