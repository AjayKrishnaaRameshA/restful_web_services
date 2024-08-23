package com.ajay.restful_api.mapper;

import com.ajay.restful_api.dto.UserDto;
import com.ajay.restful_api.model.User;

public class UserMapper {

	public static User mapDtoToUser(UserDto dto ) {
		User user = new User(
				dto.getId(),
				dto.getFirstName(),
				dto.getLastName(),
				dto.getEmail());
		return user;
	}
	
	public static UserDto mapToDto(User user ) {
		UserDto userDto = new UserDto(
				user.getId(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmail());
		return userDto;
	}
}
