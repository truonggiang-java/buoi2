package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dto.JwtResponseDto;
import com.example.employee.dto.LoginDto;
import com.example.employee.jwt.JWTTokenComponent;
import com.example.employee.jwt.JWTUsersDetailService;
import com.example.employee.service.UsersService;

@RestController
@RequestMapping("/accounts")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTTokenComponent tokenComponent;
	
	@Autowired
	private JWTUsersDetailService jwtUserDetailService;
	
	@PostMapping("/authenticate")
	public ResponseEntity<JwtResponseDto> authenticate(@RequestBody LoginDto loginDto){
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
		UserDetails userDetails=jwtUserDetailService.loadUserByUsername(loginDto.getUsername());
		String token=tokenComponent.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponseDto(token));
	}
}
