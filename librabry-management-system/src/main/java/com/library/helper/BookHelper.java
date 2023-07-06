package com.library.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.entity.Book;
import com.library.exception.ResorceNotFoundException;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import com.library.request.BookRequest;
import com.library.responce.BookResponce;
import com.library.serivce.AuthorService;
import com.library.serivce.BookService;

@Component
public class BookHelper {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	AuthorRepository authorRepository;

	public Book toEntity(BookRequest bookRequest) throws ResorceNotFoundException {
		Book book = new Book();
		if (bookRequest.getBid() != null) {
			book = this.bookRepository.findById(bookRequest.getBid())
					.orElseThrow(() -> new RuntimeException("Book is not found"));
		}
//		if(bookRepository.existsBookByBname(bookRequest.getBname())) {
//			throw new RuntimeException("Bname found ");
//		}
		book.setBid(bookRequest.getBid());
		book.setBname(bookRequest.getBname());
		book.setPrice(bookRequest.getPrice());
		book.setAuthor(authorRepository.getReferenceById(bookRequest.getAid()));

		return book;
	}

	public BookResponce toDto(Book book) {
		BookResponce bookResponce = new BookResponce();
		bookResponce.setBid(book.getBid());
		bookResponce.setBname(book.getBname());
		bookResponce.setPrice(book.getPrice());
//		bookResponce.setAuthor(book.getAuthor());

		bookResponce.setAid(book.getAuthor().getAid());
		bookResponce.setName(book.getAuthor().getName());
		bookResponce.setEmail(book.getAuthor().getEmail());

		//bookResponce.setAid(book.getAuthor().getAid());
		return bookResponce;

	}
}
