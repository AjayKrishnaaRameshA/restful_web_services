package com.ajay.restful_api.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.ajay.restful_api.dto.UserDto;
import com.ajay.restful_api.exception.EmailAlreadyExistException;
import com.ajay.restful_api.exception.ResourceNotFoundException;
import com.ajay.restful_api.model.User;
import com.ajay.restful_api.mapper.MapStructMapper;
import com.ajay.restful_api.mapper.UserMapper;
import com.ajay.restful_api.repo.UserRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
@ComponentScan(basePackages = {"com.ajay.restful_api"})
public class UserServiceImpl implements UserService{

	@Autowired
	public UserRepository repository;
	
	//@Autowired
	//private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		//User user = UserMapper.mapDtoToUser(userDto);
		//User user=modelMapper.map(userDto, User.class);
		
		Optional<User> opt=repository.findByEmail(userDto.getEmail());
		
		if(opt.isPresent()) {
			throw new EmailAlreadyExistException("email already exists");
		}
		
		User user=MapStructMapper.newMapper.maptoUser(userDto);
		
		User savedUser=repository.save(user);
		
		//for dto mapping class
		// return UserMapper.mapToDto(savedUser);
		
		// for modelmapper class
		//return modelMapper.map(savedUser, UserDto.class);
		
		//for mapstruct
		return MapStructMapper.newMapper.maptoDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto dto) {
		User optUser=repository.findById(dto.getId()).orElseThrow(
				()-> new ResourceNotFoundException("User","id", dto.getId())
				);
		optUser.setFirstName(dto.getFirstName());
		optUser.setLastName(dto.getLastName());
		optUser.setEmail(dto.getEmail());
		User savedUser=repository.save(optUser);
		
		//for dto mapping class
		//return UserMapper.mapToDto(savedUser);
		
		//for modelmapper
		//return modelMapper.map(savedUser, UserDto.class);
		
		//for mapstruct
		return MapStructMapper.newMapper.maptoDto(savedUser);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users=repository.findAll();
		
		//for dto mapping
		//return users.stream().map(UserMapper::mapToDto).collect(Collectors.toList());
		
		//for modelmapper
		//return users.stream().map((user)->modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		
		//for mapstruct
		return users.stream().map((user)-> MapStructMapper.newMapper.maptoDto(user)).collect(Collectors.toList());
	}

	@Override
	public void deleteUser(Long id) {
		User optUser=repository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("User","id", id)
				);
		repository.deleteById(id);
		
	}

	@Override
	public UserDto getUSerById(Long id) {
		// TODO Auto-generated method stub
		User user=repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id", id));
		
		// for dto mapping class
		// return UserMapper.mapToDto(user);
			
		//for modelmapper
		//return modelMapper.map(user, UserDto.class);
		
		//for mapstruct
		return MapStructMapper.newMapper.maptoDto(user);
	}

}

 	