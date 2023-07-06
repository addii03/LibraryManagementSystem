package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.exception.ResorceNotFoundException;
import com.library.helper.UserHelper;
import com.library.request.UserRequest;
import com.library.responce.UserResponce;
import com.library.serivce.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserHelper userHelper;

	@PostMapping("save")
	public ResponseEntity<UserResponce> saveUser(@RequestBody UserRequest userRequest) {
		return new ResponseEntity<UserResponce>(userService.saveUser(userRequest), HttpStatus.CREATED);
	}

	@GetMapping("/all")

	public List<UserResponce> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable int id) throws ResorceNotFoundException {

		return new ResponseEntity<Object>(userService.getUserById(id), HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable int id) throws ResorceNotFoundException {

		userService.deleteById(id);
		return new ResponseEntity<Object>("deleted successfully", HttpStatus.OK);

	}

	@DeleteMapping("/softdelete/{id}")

	public ResponseEntity<Object> softDelete(@PathVariable Integer id) throws ResorceNotFoundException {
		userService.softDelete(id);
		return new ResponseEntity<Object>("SoftDeleted Successfully :" + id, HttpStatus.OK);
	}
	@GetMapping("/nondeleted")
	public List<UserResponce>findAllByDeleted()
	{
		return userService.findAllByDeleted();
		 
	}
}
