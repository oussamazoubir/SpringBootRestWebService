package com.user.management.assembler;

import org.springframework.stereotype.Component;

import com.user.management.dto.CreateUserDto;
import com.user.management.dto.UpdateUserDto;
import com.user.management.dto.UserDto;
import com.user.management.entity.User;
import com.user.management.util.UserUtil;

@Component
public class UserAssembler {

	/**
	 * CreateUserVO convert to User.
	 *
	 * @param createUserVO
	 * @return
	 */
	public User toUser(CreateUserDto createUserDto) {
		User user = new User();
		user.setFirstName(createUserDto.getFirstName());
		user.setLastName(createUserDto.getLastName());
		user.setUsername(createUserDto.getUsername());
		return user;
	}

	/**
	 * User to UserVO.
	 *
	 * @param user
	 * @return
	 */
	public UserDto toUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setUserId(user.getId());
		userDto.setFullName(UserUtil.convertToFullName(user.getFirstName(), user.getLastName()));
		userDto.setUsername(user.getUsername());
		return userDto;

	}

	/**
	 * UpdateUserVO to user.
	 *
	 * @param updateUserVO
	 * @return
	 */
	public User toUser(UpdateUserDto updateUserDto) {
		User user = new User();
		user.setId(updateUserDto.getUserId());
		user.setFirstName(updateUserDto.getFirstName());
		user.setLastName(updateUserDto.getLastName());
		user.setUsername(updateUserDto.getUsername());
		return user;
	}
}
