package com.ajay.restful_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ajay.restful_api.dto.UserDto;
import com.ajay.restful_api.model.User;


@Mapper(componentModel = "spring")
public interface MapStructMapper {

	MapStructMapper newMapper = Mappers.getMapper(MapStructMapper.class);
	
	UserDto maptoDto(User user);
	

	User maptoUser(UserDto userDto);

}
