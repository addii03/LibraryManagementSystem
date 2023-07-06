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
import com.library.helper.AuthorHelper;
import com.library.request.AuthorRequest;
import com.library.responce.AuthorResponce;
import com.library.serivce.AuthorService;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

	@Autowired
	private	AuthorHelper authorHelper;
	
	@Autowired
	private AuthorService authorService;
	
	@PostMapping("/save")
	public ResponseEntity<AuthorResponce> saveAuthors(@RequestBody AuthorRequest authorRequest) throws ResorceNotFoundException
	{
	 return new ResponseEntity<AuthorResponce>(authorService.saveAuthors(authorRequest), HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public List<AuthorResponce>getAllAuthors(){
		return authorService.getAllAuthors();
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<AuthorResponce> FindById(@PathVariable Integer id) throws ResorceNotFoundException
	{
		return new ResponseEntity<AuthorResponce>(authorService.FindById(id), HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object>deleteById(@PathVariable Integer id) throws ResorceNotFoundException
	{
		authorService.deleteById(id);
		return new ResponseEntity<Object>("Author deleted succussfully : " + id,HttpStatus.OK);
	}
	@DeleteMapping("/softdelete/{id}")
	public ResponseEntity<Object>softDeleteById(@PathVariable Integer id) throws ResorceNotFoundException
	{
		authorService.softDeleteById(id);
		return new ResponseEntity<Object>("softdeleted succussfully : "+ id, HttpStatus.OK);
	}
	@GetMapping("/nondeleted")
	public List<AuthorResponce> findByIdAllDeletedFalse(){
		return authorService.findByIdAllDeletedFalse();
		
	}
	
}
