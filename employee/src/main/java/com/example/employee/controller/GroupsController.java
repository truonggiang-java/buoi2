package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.service.GroupsService;

@RestController
@RequestMapping("/api/v1")
public class GroupsController {
	@Autowired
	private GroupsService groupsService;
	
	@GetMapping("/groups")
	private ResponseEntity<Object> findAllGroups(){
		return new ResponseEntity<>(groupsService.findAllGroups(),HttpStatus.OK);
	}
}
