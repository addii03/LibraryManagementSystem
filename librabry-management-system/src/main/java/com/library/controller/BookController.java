package com.library.controller;

import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.exception.ResorceNotFoundException;
import com.library.helper.BookHelper;
import com.library.request.BookRequest;
import com.library.responce.BookResponce;
import com.library.serivce.BookService;

@RestController
@RequestMapping("/api/book")

public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private BookHelper bookHelper;

//	@Autowired
//	Validator validator;

	@PostMapping("/save")
//	public ResponseEntity<BookResponce> saveBooks(@Valid @RequestBody BookRequest bookRequest) throws ResorceNotFoundException {
	public ResponseEntity<BookResponce> saveBooks(@RequestBody BookRequest bookRequest)
			throws ResorceNotFoundException {
//	validator.validate
		return new ResponseEntity<BookResponce>(bookService.saveBooks(bookRequest), HttpStatus.OK);
	}

	@GetMapping("/all")
	public List<BookResponce> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getBookById(@PathVariable int id) throws ResorceNotFoundException {

		return new ResponseEntity<Object>(bookService.getBookById(id), HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable int id) throws ResorceNotFoundException {

		bookService.deleteById(id);
		return new ResponseEntity<Object>("deleted successfully : ID" + id, HttpStatus.OK);

	}

	@DeleteMapping("/softDeleted/{id}")
	public ResponseEntity<Object> softDeleted(@PathVariable Integer id) throws ResorceNotFoundException {
		bookService.softDeletedById(id);
		return new ResponseEntity<Object>("Softdeleted successfully ID : " + id, HttpStatus.OK);
	}

	@GetMapping("/nondeleted")
	public List<BookResponce> findAllByDeleted() {
		return bookService.findAllByDeleted();

	}

	@GetMapping("/search")
	public ResponseEntity<List<BookResponce>> findByBnameLike(@RequestParam("query") String bname) {
		return new ResponseEntity<List<BookResponce>>(bookService.findByBnameLike(bname), HttpStatus.OK);
	}

}
