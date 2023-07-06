package com.library.controller;

import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Librarian;
import com.library.exception.ResorceNotFoundException;
import com.library.helper.LibrarianHelper;
import com.library.request.LibrarianRequest;
import com.library.responce.LibrarianResponce;
import com.library.serivce.LibrarianService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/librarian")
public class LibrarianController {

	@Autowired
	private LibrarianService librarianService;

	@Autowired
	private LibrarianHelper librarianHelper;

//	public LibrarianController(LibrarianService librarianService) {
//		super();
//		this.librarianService = librarianService;
//	}

	@PostMapping("/save")
	public ResponseEntity<LibrarianResponce> saveLibrarian(@RequestBody LibrarianRequest librarianRequest) {

		LibrarianResponce librarianResponce = this.librarianService.saveLibrarian(librarianRequest);

		return new ResponseEntity<LibrarianResponce>(librarianResponce, HttpStatus.OK);

//		return new ResponseEntity<LibrarianResponce>(librarianService.saveLibrarian(librarianRequest),
//				HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public List<LibrarianResponce> getAllLibrarian() {
		return librarianService.getAllLibrarian();
	}

	@GetMapping("{id}")
	public Callable<ResponseEntity<Object>> getLibrarianById(@PathVariable int id) {

		return () -> new ResponseEntity<Object>(librarianService.getLibrarianById(id), HttpStatus.OK);

	}

//	@PutMapping ("/update/{id}")
//	public ResponseEntity<LibrarianResponce> updateById(@PathVariable int id,@RequestBody LibrarianRequest librarianRequest)
//	{
//		return new ResponseEntity<LibrarianResponce>(librarianService.updateById(id, librarianRequest), HttpStatus.OK);
//	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deletById(@PathVariable int id) throws ResorceNotFoundException {

		librarianService.deletById(id);
		return new ResponseEntity<Object>("deleted successfully", HttpStatus.OK);

	}
	@DeleteMapping("/softdelete/{id}")
	public ResponseEntity<Object> softDeleteById(@PathVariable Integer id) throws ResorceNotFoundException{
		librarianService.softDeleteById(id);
		return new ResponseEntity<Object>("softDeleted successfully : "+ id, HttpStatus.OK);
	}
	
	@GetMapping("/getAllNonDeleted") 
	public List<LibrarianResponce> findAllByDeleted()
	{
		return librarianService.findAllByDeleted();
	}
}
