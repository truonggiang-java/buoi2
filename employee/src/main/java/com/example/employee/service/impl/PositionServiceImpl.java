package com.example.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employee.entity.Position;
import com.example.employee.repository.PositionRepository;
import com.example.employee.service.PositionService;

@Service
@Transactional(rollbackFor = Exception.class)
public class PositionServiceImpl implements PositionService{
	@Autowired
	private PositionRepository positionRepository;

	@Override
	public void insert(Position p) {
		positionRepository.insert(p);
		
	}

	@Override
	public void update(Position p) {
		positionRepository.update(p);
		
	}

	@Override
	public Position findById(Integer id) {
		// TODO Auto-generated method stub
		return positionRepository.findById(id);
	}

	@Override
	public List<Position> findAllPosition() {
		// TODO Auto-generated method stub
		return positionRepository.findAllPosition();
	}
}
