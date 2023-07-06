package com.library.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.User;
import com.library.exception.ResorceNotFoundException;
import com.library.helper.UserHelper;
import com.library.repository.UserRepository;
import com.library.request.UserRequest;
import com.library.responce.UserResponce;
import com.library.serivce.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserHelper userHelper;

	@Override
	public UserResponce saveUser(UserRequest userRequest) {
		
		User user = userHelper.toEntity(userRequest);
		this.userRepository.save(user);
		return userHelper.toDto(user);
	}

	@Override
	public List<UserResponce> getAllUsers() {
		List<User> userlist = new ArrayList<>();// userRepository.findAll();
		List<UserResponce> userResponces = userlist.stream().map(u -> {
			UserResponce userResponce1 = new UserResponce(u.getUid(), u.getUname(), u.getEmail(), false);
			return userResponce1;

		}).collect(Collectors.toList());
		return userResponces;
	}

	@Override
	public UserResponce getUserById(int id) throws ResorceNotFoundException {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResorceNotFoundException("User not found this id :: " + id));
		UserResponce userResponce = userHelper.toDto(user);
		return userResponce;
	}

	@Override
	public void deleteById(int id) throws ResorceNotFoundException {
		userRepository.findById(id).orElseThrow(() -> new ResorceNotFoundException("User not found this id :: " + id));
		userRepository.deleteById(id);

	}

	@Override
	public void softDelete(Integer id) throws ResorceNotFoundException {

		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResorceNotFoundException("User not found this id :: " + id));
		user.setDeleted(true);
		userRepository.save(user);

	}

	@Override
	public List<UserResponce> findAllByDeleted() {
		List<User> allByDeleted = userRepository.findAllByDeleted(false);
		List<UserResponce> userResponces = allByDeleted.stream().map(u -> {
			UserResponce userResponce1 = new UserResponce(u.getUid(), u.getUname(), u.getEmail(), false);
			return userResponce1;
		}).collect(Collectors.toList());
		return userResponces;

	}

}
