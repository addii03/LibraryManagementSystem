package com.library.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.library.entity.User;
import com.library.repository.UserRepository;
import com.library.request.UserRequest;
import com.library.responce.UserResponce;
@Component
public class UserHelper {

	@Autowired
	UserRepository userRepository;
	public User toEntity (UserRequest userRequest)
	{
		User user = new User();
		if (userRequest.getUid() != null) {
			user = this.userRepository.findById(userRequest.getUid())
					.orElseThrow(() -> new RuntimeException("User not found"));
		}
		
		user.setUid(userRequest.getUid());
		user.setEmail(userRequest.getEmail());
		user.setUname(userRequest.getUname());
		return user;
		
	}

	public UserResponce toDto (User user) {
		UserResponce userResponce = new UserResponce();
		userResponce.setUid(user.getUid());
		userResponce.setUname(user.getUname());
		userResponce.setEmail(user.getEmail());
		return userResponce;
		
	}
}
