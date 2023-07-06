package com.library.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.entity.Book;
import com.library.entity.BookUser;
import com.library.exception.ResorceNotFoundException;
import com.library.repository.BookRepository;
import com.library.repository.BookUserRepository;
import com.library.repository.LibrarianRepository;
import com.library.repository.UserRepository;
import com.library.request.BookUserRequest;
import com.library.responce.BookUserResponce;

@Component
public class BookUserHelper {

	@Autowired
	BookUserRepository bookUserRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	LibrarianRepository librarianRepository;

	public BookUser toEntity(BookUserRequest bookUserRequest) throws ResorceNotFoundException {
		BookUser bookUser = new BookUser();
		if (bookUserRequest.getBook_user_id() != null) {
			bookUser = bookUserRepository.findById(bookUserRequest.getBook_user_id())
					.orElseThrow(() -> new ResorceNotFoundException("Book User not found"));
		}

		bookUser.setBook_user_id(bookUserRequest.getBook_user_id());
		bookUser.setDeleted(bookUserRequest.isDeleted());
		bookUser.setBook(bookRepository.getReferenceById(bookUserRequest.getBid()));
		bookUser.setLibrarian(librarianRepository.getReferenceById(bookUserRequest.getLid()));
		bookUser.setUser(userRepository.getReferenceById(bookUserRequest.getUid()));
		return bookUser;

	}

	public BookUserResponce toDto(BookUser bookUser) {
		BookUserResponce bookUserResponce = new BookUserResponce();

		bookUserResponce.setBook_user_id(bookUser.getBook_user_id());
		bookUserResponce.setDeleted(false);
		// to set book
		bookUserResponce.setBid(bookUser.getBook().getBid());
		bookUserResponce.setBname(bookUser.getBook().getBname());
		bookUserResponce.setPrice(bookUser.getBook().getPrice());

		// tp set librarian
		bookUserResponce.setLid(bookUser.getLibrarian().getLid());
		bookUserResponce.setLname(bookUser.getLibrarian().getLname());
		bookUserResponce.setAddress(bookUser.getLibrarian().getAddress());

		// to set user
		bookUserResponce.setUid(bookUser.getUser().getUid());
		bookUserResponce.setUname(bookUser.getUser().getUname());
		bookUserResponce.setEmail(bookUser.getUser().getEmail());
		return bookUserResponce;
	}
}
