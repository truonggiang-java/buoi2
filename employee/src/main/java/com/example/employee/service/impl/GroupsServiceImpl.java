package com.example.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.entity.Groups;
import com.example.employee.repository.GroupsRepository;
import com.example.employee.service.GroupsService;
@Service
public class GroupsServiceImpl implements GroupsService{
	@Autowired
	private GroupsRepository groupsRepository;
	
	@Override
	public List<Groups> findAllGroups() {
		// TODO Auto-generated method stub
		return groupsRepository.findAllGroups();
	}
	
	
}
