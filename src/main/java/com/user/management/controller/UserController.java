package com.user.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.assembler.UserAssembler;
import com.user.management.dto.CreateUserDto;
import com.user.management.dto.UpdateUserDto;
import com.user.management.dto.UserDto;
import com.user.management.entity.User;
import com.user.management.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserAssembler userAssembler;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserDto getUser(@PathVariable("id") Long id) {
		return userAssembler.toUserDto(userService.getUserById(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	public UserDto createUser(@RequestBody CreateUserDto userDto) {
		// convert to User
		User user = userAssembler.toUser(userDto);
		// save User
		User savedUser = userService.createUser(user);
		// convert to UserDto
		return userAssembler.toUserDto(savedUser);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public UserDto updateUser(@RequestBody UpdateUserDto updateUserDto) {
		// convert to User
		User user = userAssembler.toUser(updateUserDto);
		// update User
		User updatedUser = userService.updateUser(user);
		// convert to UserDto
		return userAssembler.toUserDto(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		userService.deleteUser(id);
	}
}
