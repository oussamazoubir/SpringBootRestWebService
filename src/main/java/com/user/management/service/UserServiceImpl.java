package com.user.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.management.entity.User;
import com.user.management.exception.ResourceNotFoundException;
import com.user.management.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public User getUserById(Long id) {
		 User user = userRepository.findOne(id);
		if (user == null) {
            throw new ResourceNotFoundException(id, "user not found");
        }
		return userRepository.findOne(id);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		User user = getUserById(id);
		if (user != null) {
			userRepository.delete(id);
		}
	}

}
