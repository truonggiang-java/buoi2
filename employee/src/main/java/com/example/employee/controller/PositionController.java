package com.example.employee.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.employee.convertor.PositionConvertor;
import com.example.employee.dto.PositionDto;
import com.example.employee.entity.Position;
import com.example.employee.service.PositionService;

@RestController
@RequestMapping("/api/v1")
public class PositionController {
	@Autowired
	private PositionService positionService;
	
	@Autowired
	private PositionConvertor positionConvertor;
	
	@PostMapping("/position")
	private ResponseEntity<Object> insert(@RequestBody PositionDto positionDto,Errors errors){
		if(errors.hasErrors()) {
			return new ResponseEntity<>(errors.getAllErrors().stream().map(objectErrors -> objectErrors.getDefaultMessage()).collect(Collectors.toList()),HttpStatus.BAD_REQUEST);
		}
		Position position=positionConvertor.convertor(positionDto,positionDto.getId());
		positionService.insert(position);
		return new ResponseEntity<>("Thêm mới thành công", HttpStatus.OK);
	}
	
	@PutMapping("/position/{id}")
	private ResponseEntity<Object> update(@RequestBody PositionDto positionDto,@PathVariable("id") Integer id){
		Position position=positionConvertor.convertor(positionDto, id);
		positionService.update(position);
		return new ResponseEntity<>("Cập nhật thành công", HttpStatus.OK);
	}
	
	@GetMapping("/position/{id}")
	private ResponseEntity<Object> findById(@PathVariable("id") Integer id){
		return new ResponseEntity<>(positionService.findById(id),HttpStatus.OK);
	}
	
	@GetMapping("/position")
	private ResponseEntity<Object> findAllPosition(){
		return new ResponseEntity<>(positionService.findAllPosition(),HttpStatus.OK);
	}
}
