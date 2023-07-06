package com.library.serivce;

import java.util.List;

import com.library.entity.Book;
import com.library.exception.ResorceNotFoundException;
import com.library.request.BookRequest;
import com.library.responce.BookResponce;

public interface BookService {

	BookResponce saveBooks (BookRequest bookRequest) throws ResorceNotFoundException;
	List<BookResponce> getAllBooks();
	
	List<BookResponce> findAllByDeleted();
	
	BookResponce getBookById(int id) throws ResorceNotFoundException;
	void deleteById(int id) throws ResorceNotFoundException;
	
	void softDeletedById(Integer id) throws ResorceNotFoundException;
	
	//List<BookResponce>searchByBooks(String query);
	
	List<BookResponce> findByBnameLike(String bname);
}
