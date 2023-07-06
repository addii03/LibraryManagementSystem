package com.library.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.exception.ResorceNotFoundException;
import com.library.helper.BookHelper;
import com.library.repository.BookRepository;
import com.library.request.BookRequest;
import com.library.responce.BookResponce;
import com.library.serivce.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookHelper bookHelper;

	// save and update
	@Override
	public BookResponce saveBooks(BookRequest bookRequest) throws ResorceNotFoundException {
		Book book = bookHelper.toEntity(bookRequest);
		this.bookRepository.save(book);
		return bookHelper.toDto(book);
	}

	@Override
	public List<BookResponce> getAllBooks() {
		List<Book> findAll = bookRepository.findAll();
		return findAll.stream().map(bookHelper::toDto).collect(Collectors.toList());

	}

	@Override
	public BookResponce getBookById(int id) throws ResorceNotFoundException {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResorceNotFoundException("Book not found this id :: " + id));
		BookResponce bookResponce = bookHelper.toDto(book);
		return bookResponce;
	}

	@Override
	public void deleteById(int id) throws ResorceNotFoundException {
		bookRepository.findById(id).orElseThrow(() -> new ResorceNotFoundException("Book not found this id ::" + id));
		bookRepository.deleteById(id);
	}

	@Override
	public void softDeletedById(Integer id) throws ResorceNotFoundException {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResorceNotFoundException("Book not found this id ::" + id));
		book.setDeleted(true);
		bookRepository.save(book);

	}

	@Override
	public List<BookResponce> findAllByDeleted() {
		List<Book> findAllByDeleted = bookRepository.findAllByDeleted(false);
		return findAllByDeleted.stream().map(bookHelper::toDto).collect(Collectors.toList());

	}

	@Override
	public List<BookResponce> findByBnameLike(String bname) {
		List<Book> findByBnameContaining = bookRepository.findByBnameLike("%"+bname+"%");
		return	findByBnameContaining.stream().map(bookHelper::toDto).collect(Collectors.toList());
		
	}

	

}
