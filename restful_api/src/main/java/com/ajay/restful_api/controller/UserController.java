package com.ajay.restful_api.controller;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.ajay.restful_api.dto.UserDto;
import com.ajay.restful_api.exception.ErrorDetails;
import com.ajay.restful_api.exception.ResourceNotFoundException;
import com.ajay.restful_api.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(
	name = "CRUD REST APIs for User Resource",
	description = "CRUD REST APIs - Create User, Update User, Get User, Get All Users, Delete User"
)
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService service;
	
	@Operation(
			summary="create User REST API",
			description = "creating a new user in the database"
	)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP status 201 created"
	)
	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto dto){
		UserDto userdto=service.createUser(dto);
		return new ResponseEntity<>(userdto, HttpStatus.CREATED);
	}
	
	
	@Operation(
			summary="get All Users REST API",
			description = "get all users from the database"
	)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP status 200 OK"
	)
	@GetMapping
	public ResponseEntity<List<UserDto>> findAll(){
		return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
	}
	
	
	@Operation(
			summary="get a single User REST API",
			description = "getting a single user from the database"
	)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP status 200 OK"
	)
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getById(@PathVariable("id") Long id){
		return new ResponseEntity<>(service.getUSerById(id), HttpStatus.OK);
	}
	
	
	
	@Operation(
			summary="update a single User REST API",
			description = "updating a single user in the database"
	)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP status 200 OK"
	)
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody @Valid UserDto dto){
		dto.setId(id);
		UserDto savedUser=service.updateUser(dto);
		return new ResponseEntity<>(savedUser, HttpStatus.OK );
	}
	
	
	@Operation(
			summary="deleting a single User REST API",
			description = "deleting a single user from the database"
	)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP status 200 OK"
	)
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id")Long id) {
		service.deleteUser(id);
		return new ResponseEntity<>("user deleted successfully", HttpStatus.OK);
	}
	
//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<ErrorDetails> resourceNotFoundHandler(ResourceNotFoundException exception,
//																WebRequest request) {
//		ErrorDetails details = new ErrorDetails(
//				LocalDateTime.now(),
//				exception.getMessage(),
//				request.getDescription(false),
//				"USER_NOT_FOUND"
//				);
//		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
//	}
}
