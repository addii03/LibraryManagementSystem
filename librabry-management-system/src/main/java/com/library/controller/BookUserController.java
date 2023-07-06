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
import com.library.helper.BookUserHelper;
import com.library.request.BookUserRequest;
import com.library.responce.BookUserResponce;
import com.library.serivce.BookUserService;

@RestController
@RequestMapping("/bookUser")
public class BookUserController {

	@Autowired
	BookUserHelper bookUserHelper;
	@Autowired
	BookUserService bookUserService;
	
	@PostMapping("/save")
	public ResponseEntity<BookUserResponce>saveBookUsers(@RequestBody BookUserRequest bookUserRequest) throws ResorceNotFoundException
	{
		return new ResponseEntity<BookUserResponce>(bookUserService.saveBookUsers(bookUserRequest), HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public List<BookUserResponce> getAllBookUsers()
	{
		return bookUserService.getAllBookUsers();
	}
	@GetMapping("/byid/{id}")
	
	public ResponseEntity<BookUserResponce> getBookUsersById(@PathVariable Integer id)
	{
		return new ResponseEntity<BookUserResponce>(bookUserService.getBookUsersById(id), HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deleteById(@PathVariable Integer id) throws ResorceNotFoundException
	{
		bookUserService.deleteById(id);
		return new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
	}
	@DeleteMapping("/softdelete/{id}")
	public ResponseEntity<String> softDeleteById(@PathVariable Integer id) throws ResorceNotFoundException
	{
		bookUserService.softDeleteById(id);
		return new ResponseEntity<String>("Softdeleted successfully", HttpStatus.OK);
	}
}
