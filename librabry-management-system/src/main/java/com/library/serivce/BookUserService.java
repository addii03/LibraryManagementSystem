package com.library.serivce;

import java.util.List;

import com.library.entity.BookUser;
import com.library.exception.ResorceNotFoundException;
import com.library.request.BookUserRequest;
import com.library.responce.BookUserResponce;

public interface BookUserService {

	BookUserResponce saveBookUsers(BookUserRequest bookUserRequest) throws ResorceNotFoundException;
	List<BookUserResponce>getAllBookUsers();
	BookUserResponce getBookUsersById(Integer id);
	void deleteById(Integer id) throws ResorceNotFoundException;
	void softDeleteById(Integer id) throws ResorceNotFoundException;
	//BookUserResponce updateBookUserById(Integer id);
}
