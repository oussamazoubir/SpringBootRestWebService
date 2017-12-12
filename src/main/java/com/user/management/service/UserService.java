package com.user.management.service;

import com.user.management.entity.User;

public interface UserService {

	User getUserById(Long id);

	User createUser(User user);

	User updateUser(User user);

	void deleteUser(Long id);

}
