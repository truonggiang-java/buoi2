package com.example.employee.repository;

import java.util.List;

import com.example.employee.entity.Position;

public interface PositionRepository {
	void insert(Position p);
	void update(Position p);
	Position findById(Integer id);
	List<Position> findAllPosition();
}
