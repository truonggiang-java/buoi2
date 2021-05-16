package com.example.employee.repository;

import java.util.List;

import com.example.employee.entity.Groups;

public interface GroupsRepository {
	List<Groups> findAllGroups();
}
