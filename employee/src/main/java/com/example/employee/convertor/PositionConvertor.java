package com.example.employee.convertor;

import org.springframework.stereotype.Component;

import com.example.employee.dto.PositionDto;
import com.example.employee.entity.Position;

@Component
public class PositionConvertor {
	public Position convertor(PositionDto positionDto,Integer id) {
		Position position=new Position();
		if(id != null) {
			position.setId(id);
		}
		else {
			position.setId(null);
		}
		position.setName(positionDto.getName());
		return position;
	}
}
