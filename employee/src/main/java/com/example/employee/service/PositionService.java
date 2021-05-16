package com.example.employee.service;

import java.util.List;

import com.example.employee.entity.Position;

public interface PositionService {
	void insert(Position p);
	void update(Position p);
	Position findById(Integer id);
	List<Position> findAllPosition();
}
