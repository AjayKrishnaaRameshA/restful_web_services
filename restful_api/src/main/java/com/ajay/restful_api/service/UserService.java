package com.ajay.restful_api.service;

import java.util.List;

import com.ajay.restful_api.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto dto);
	
	UserDto getUSerById(Long id);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Long id);
}
